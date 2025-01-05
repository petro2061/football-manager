package project.footballmanager.service.player.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.footballmanager.dto.player.CreatePlayerRequestDto;
import project.footballmanager.dto.player.PlayerDto;
import project.footballmanager.mapper.PlayerMapper;
import project.footballmanager.model.Player;
import project.footballmanager.repository.player.PlayerRepository;
import project.footballmanager.service.player.PlayerService;

@RequiredArgsConstructor
@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerDto save(CreatePlayerRequestDto playerRequestDto) {
        Player player = playerRepository.save(playerMapper.toPlayerModel(playerRequestDto));
        return playerMapper.toPlayerDto(player);
    }

    @Override
    public List<PlayerDto> findAll() {
        return playerRepository.findPlayerWithTeam()
                .stream()
                .map(playerMapper::toPlayerDto)
                .toList();
    }

    @Override
    public PlayerDto findById(Long id) {
        Player player = playerRepository.findPlayerWithTeamById(id).orElseThrow(() ->
                new EntityNotFoundException("Can not find entity by id: " + id));
        return playerMapper.toPlayerDto(player);
    }

    @Transactional
    @Override
    public PlayerDto update(Long id, CreatePlayerRequestDto updatePlayerRequestDto) {
        Player player = playerRepository.findPlayerWithTeamById(id).orElseThrow(() ->
                new EntityNotFoundException("Can not find entity by id: " + id));
        playerMapper.updatePlayerModel(updatePlayerRequestDto, player);
        return playerMapper.toPlayerDto(playerRepository.save(player));
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<PlayerDto> getPlayersByTeamId(Long teamId) {
        return playerRepository.findAllByTeamId(teamId)
                .stream()
                .map(playerMapper::toPlayerDto)
                .toList();
    }
}
