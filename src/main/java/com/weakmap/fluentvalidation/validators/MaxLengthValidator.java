package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;

public class MaxLengthValidator<TProperty> extends PropertyValidator<TProperty> {

    private final int maxLength;

    public MaxLengthValidator(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Boolean validate(TProperty value) {
        return ValueHelper.getLength(value) >= maxLength;
    }
}
