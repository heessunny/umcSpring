package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.DoMissionQueryServiceImpl;
import umc.spring.validation.annotation.ExistDoMission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
@RequiredArgsConstructor
public class DoMissionExistValidator implements ConstraintValidator<ExistDoMission, Long> {

    private static final Logger logger = LoggerFactory.getLogger(DoMissionExistValidator.class);
    private final DoMissionQueryServiceImpl missionQueryService;

    @Override
    public void initialize(ExistDoMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {

        Long memberId = 1L;  // memberId는 1L로 고정

        // DoMission 테이블에서 memberId와 missionId가 일치하는 레코드가 존재하는지 확인
        boolean isValid = missionQueryService.existsByMemberIdAndMissioinId(memberId,id);

        logger.info("Checking existence of record for memberId: {}, missionId: {}. Result: {}", memberId, id, isValid);



        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return !isValid;


    }
}