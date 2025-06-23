package com.invex.employees.common.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateVaidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {
    String message() default "Fecha inválida o con formato incorrecto";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
