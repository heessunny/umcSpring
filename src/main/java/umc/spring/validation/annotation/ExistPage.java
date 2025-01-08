package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PageExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistPage {

    String message() default "해당하는 page가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
