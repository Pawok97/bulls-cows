package com.game.bullscows.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GameMoveNumberValidator implements ConstraintValidator<GameMoveNumberConstraint, String> {
    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {

        return number.matches("(?!.*(.).*\\1)\\d{4}") && number != null;
    }

    @Override
    public void initialize(GameMoveNumberConstraint number) {

    }
}
