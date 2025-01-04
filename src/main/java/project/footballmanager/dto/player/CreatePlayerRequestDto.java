package project.footballmanager.dto.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePlayerRequestDto(
        @NotBlank(message = "Filed name can't be null")
        String name,
        @Min(value = 18, message = "The player must be over 18 years old")
        int age,
        @Min(value = 0, message = "Experience month can't be less zero")
        int experienceMonths,
        @NotNull(message = "Team id can't be null")
        Long teamId
) {
}
