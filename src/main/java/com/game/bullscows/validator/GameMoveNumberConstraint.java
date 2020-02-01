package com.game.bullscows.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GameMoveNumberValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GameMoveNumberConstraint {
    String message() default   "Numbers should not be repeated, and not be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[]payload() default {};
}
