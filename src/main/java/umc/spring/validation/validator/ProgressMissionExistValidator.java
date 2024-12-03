package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.service.DoMissionQueryService;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistProgressMission;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProgressMissionExistValidator implements ConstraintValidator<ExistProgressMission, Long> {

    private final DoMissionQueryService doMissionQueryService;

    @Override
    public void initialize(ExistProgressMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {

        Long memberId =1L;
        boolean isValid = doMissionQueryService.existsProgressByMissionIdAndMemberId(missionId, memberId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PROGRESSMISSION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}