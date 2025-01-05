package project.footballmanager.service.transfer.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.footballmanager.model.Player;
import project.footballmanager.model.Team;
import project.footballmanager.repository.player.PlayerRepository;
import project.footballmanager.repository.team.TeamRepository;
import project.footballmanager.service.transfer.TransferService;

@RequiredArgsConstructor
@Service
public class TransferServiceImpl implements TransferService {
    private static final int TRANSFER_COST_COEFFICIENT = 100000;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Transactional
    @Override
    public void transferPlayer(Long transferPlayerId, Long buyingTeamId) {
        Player transferingPlayer = playerRepository.findById(transferPlayerId).orElseThrow(() ->
                new EntityNotFoundException("Can not find entity by id: " + transferPlayerId));

        Team sellingTeam = transferingPlayer.getTeam();

        Team buyingTeam = teamRepository.findById(buyingTeamId).orElseThrow(() ->
                new EntityNotFoundException("Can not find entity by id: " + buyingTeamId));

        double transferCost = calculateTransferCost(transferingPlayer);

        double transferCommission = calculateCommission(sellingTeam, transferCost);

        double totalTransferCost = transferCost + transferCommission;

        if (buyingTeam.getId().equals(sellingTeam.getId())) {
            throw new RuntimeException("The player cannot be transferred to the same team.");
        }
        if (buyingTeam.getAccountBalance() < totalTransferCost) {
            throw new RuntimeException("Insufficient funds in buying team's account. "
                    + "Required: "
                    + totalTransferCost
                    + ", Available: "
                    + buyingTeam.getAccountBalance());
        }

        buyingTeam.setAccountBalance(buyingTeam.getAccountBalance() - totalTransferCost);

        sellingTeam.setAccountBalance(sellingTeam.getAccountBalance() + totalTransferCost);

        transferingPlayer.setTeam(buyingTeam);

        playerRepository.save(transferingPlayer);
        teamRepository.save(sellingTeam);
        teamRepository.save(buyingTeam);

    }

    private double calculateTransferCost(Player player) {
        return (double) (player.getExperienceMonths() * TRANSFER_COST_COEFFICIENT)
                / player.getAge();
    }

    private double calculateCommission(Team sellingTeam, double transferCost) {
        return (sellingTeam.getCommissionPercentage() / 100) * transferCost;
    }
}
