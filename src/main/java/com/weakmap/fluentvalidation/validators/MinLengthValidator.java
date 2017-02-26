package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;

public class MinLengthValidator<TProperty> implements PropertyValidator<TProperty> {

    private int minLength;

    public MinLengthValidator(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public Boolean validate(TProperty value) {
        return ValueHelper.getLength(value) >= minLength;
    }
}
