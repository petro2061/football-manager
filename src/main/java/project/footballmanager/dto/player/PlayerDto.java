package project.footballmanager.dto.player;

import lombok.Data;

@Data
public class PlayerDto {
    private Long id;
    private String name;
    private int age;
    private int experienceMonths;
    private Long teamId;
}
