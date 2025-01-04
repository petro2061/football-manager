package project.footballmanager.service.player;

import java.util.List;
import project.footballmanager.dto.player.CreatePlayerRequestDto;
import project.footballmanager.dto.player.PlayerDto;

public interface PlayerService {
    PlayerDto save(CreatePlayerRequestDto playerRequestDto);

    List<PlayerDto> findAll();

    PlayerDto findById(Long id);

    PlayerDto update(Long id, CreatePlayerRequestDto updatePlayerRequestDto);

    void deleteById(Long id);

    List<PlayerDto> getPlayersByTeamId(Long teamId);
}
