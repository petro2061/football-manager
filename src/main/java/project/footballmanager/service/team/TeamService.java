package project.footballmanager.service.team;

import java.util.List;
import project.footballmanager.dto.team.CreateTeamRequestDto;
import project.footballmanager.dto.team.TeamDto;

public interface TeamService {
    TeamDto save(CreateTeamRequestDto teamRequestDto);

    List<TeamDto> findAll();

    TeamDto findById(Long id);

    TeamDto update(Long id, CreateTeamRequestDto updateTeamRequestDto);

    void deleteById(Long id);
}
