package project.footballmanager.dto.team;

import lombok.Data;

@Data
public class TeamDto {
    private Long id;
    private String name;
    private double accountBalance;
    private double commissionPercentage;
}
