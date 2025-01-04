package project.footballmanager.dto.team;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateTeamRequestDto(
        @NotBlank(message = "Filed name can't ce null")
        String name,
        @Min(value = 0, message = "Commission cannot be less than 0")
        @Max(value = 10, message = "Commission cannot be more than 10")
        double commissionPercentage
) {
}
