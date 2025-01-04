package project.footballmanager.mapper;

import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import project.footballmanager.config.MapperConfig;
import project.footballmanager.dto.team.CreateTeamRequestDto;
import project.footballmanager.dto.team.TeamDto;
import project.footballmanager.model.Team;

@Mapper(config = MapperConfig.class)
public interface TeamMapper {

    TeamDto toTeamDto(Team team);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountBalance", ignore = true)
    Team toTeamModel(CreateTeamRequestDto teamRequestDto);

    @Named("getTeamById")
    default Team getTeamById(Long id) {
        return Optional.ofNullable(id)
                .map(Team::new)
                .orElse(null);
    }
}
