package project.footballmanager.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import project.footballmanager.service.transfer.TransferService;

@RequiredArgsConstructor
@RestController
public class TransferController {
    private final TransferService transferService;

    @PutMapping("/{transferPlayerId}/to/{buyingTeamId}")
    public void transferPlayer(
            @PathVariable @Positive Long transferPlayerId,
            @PathVariable @Positive Long buyingTeamId) {
        transferService.transferPlayer(transferPlayerId, buyingTeamId);
    }
}
