package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStore;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDto{

        @NotNull
        Float score;
        @NotBlank
        String content;
        @NotEmpty
        List<String> imageList;


    }

}

