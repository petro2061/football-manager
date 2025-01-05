package project.footballmanager.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.footballmanager.dto.player.CreatePlayerRequestDto;
import project.footballmanager.dto.player.PlayerDto;
import project.footballmanager.service.player.PlayerService;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto createPlayer(@RequestBody @Valid CreatePlayerRequestDto playerRequestDto) {
        return playerService.save(playerRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto getPlayerById(@PathVariable @Positive Long id) {
        return playerService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDto updatePlayer(
            @PathVariable @Positive Long id,
            @RequestBody @Valid CreatePlayerRequestDto updatePlayerRequestDto) {
        return playerService.update(id, updatePlayerRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable @Positive Long id) {
        playerService.deleteById(id);
    }

    @GetMapping("/team/{teamId}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDto> getPlayersByTeamId(@PathVariable @Positive Long teamId) {
        return playerService.getPlayersByTeamId(teamId);
    }
}
