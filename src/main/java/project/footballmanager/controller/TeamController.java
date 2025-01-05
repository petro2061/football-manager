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
import project.footballmanager.dto.team.CreateTeamRequestDto;
import project.footballmanager.dto.team.TeamDto;
import project.footballmanager.service.team.TeamService;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto createTeam(@RequestBody @Valid CreateTeamRequestDto teamRequestDto) {
        return teamService.save(teamRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDto> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDto getTeamById(@PathVariable @Positive Long id) {
        return teamService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDto updateTeam(
            @PathVariable @Positive Long id,
            @RequestBody @Valid CreateTeamRequestDto updateTeamRequestDto) {
        return teamService.update(id, updateTeamRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable @Positive Long id) {
        teamService.deleteById(id);
    }
}
