package project.footballmanager.dto.player;

import lombok.Data;
import project.footballmanager.model.Team;

@Data
public class PlayerDto {
    private Long id;
    private String name;
    private int age;
    private int experienceMonths;
    private Team team;
}
