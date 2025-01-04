package project.footballmanager.service.team.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.footballmanager.dto.team.CreateTeamRequestDto;
import project.footballmanager.dto.team.TeamDto;
import project.footballmanager.mapper.TeamMapper;
import project.footballmanager.model.Team;
import project.footballmanager.repository.team.TeamRepository;
import project.footballmanager.service.team.TeamService;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public TeamDto save(CreateTeamRequestDto teamRequestDto) {
        Team team = teamRepository.save(teamMapper.toTeamModel(teamRequestDto));
        return teamMapper.toTeamDto(team);
    }

    @Override
    public List<TeamDto> findAll() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toTeamDto)
                .toList();
    }

    @Override
    public TeamDto findById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can not find entity by id: " + id));
        return teamMapper.toTeamDto(team);
    }

    @Override
    public TeamDto update(Long id, CreateTeamRequestDto updateTeamRequestDto) {
        Team team = teamRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can not find entity by id: " + id));
        teamMapper.updateTeamModel(updateTeamRequestDto, team);
        return teamMapper.toTeamDto(teamRepository.save(team));
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
