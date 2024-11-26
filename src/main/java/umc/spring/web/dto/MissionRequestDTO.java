package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionDto{



        Integer point;

        Integer minimumAmount;

        String Type;

        LocalDate deadline;



    }
}
