package com.example.demorestservice.annotations;

import com.example.demorestservice.utils.PasswordConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ANNOTATION_TYPE, FIELD, TYPE})
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
public @interface ValidPassword {

    String message() default "Invalid password";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
