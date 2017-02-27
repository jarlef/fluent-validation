package com.github.jarlef.fluentvalidation.validators;

import com.github.jarlef.fluentvalidation.PropertyValidator;

public class MinLengthValidator<TProperty> extends PropertyValidator<TProperty> {

    private int minLength;

    public MinLengthValidator(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public Boolean validate(TProperty value) {
        return ValueHelper.getLength(value) >= minLength;
    }
}
