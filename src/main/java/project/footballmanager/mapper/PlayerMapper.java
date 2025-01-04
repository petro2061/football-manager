package project.footballmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.footballmanager.config.MapperConfig;
import project.footballmanager.dto.player.CreatePlayerRequestDto;
import project.footballmanager.dto.player.PlayerDto;
import project.footballmanager.model.Player;

@Mapper(config = MapperConfig.class, uses = TeamMapper.class)
public interface PlayerMapper {
    PlayerDto toPlayerDto(Player player);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", source = "teamId", qualifiedByName = "getTeamById")
    Player toPlayerModel(CreatePlayerRequestDto playerRequestDto);
}
