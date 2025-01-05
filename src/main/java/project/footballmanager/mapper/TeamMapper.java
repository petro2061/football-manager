package project.footballmanager.mapper;

import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import project.footballmanager.config.MapperConfig;
import project.footballmanager.dto.team.CreateTeamRequestDto;
import project.footballmanager.dto.team.TeamDto;
import project.footballmanager.model.Team;

@Mapper(config = MapperConfig.class)
public interface TeamMapper {
    TeamDto toTeamDto(Team team);

    @Mapping(target = "id", ignore = true)
    Team toTeamModel(CreateTeamRequestDto teamRequestDto);

    @Mapping(target = "id", ignore = true)
    void updateTeamModel(CreateTeamRequestDto updateTeamRequestDto, @MappingTarget Team team);

    @Named("getTeamById")
    default Team getTeamById(Long id) {
        return Optional.ofNullable(id)
                .map(Team::new)
                .orElse(null);
    }
}
