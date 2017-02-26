package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;

public class NotNullValidator<TProperty> implements PropertyValidator<TProperty> {

    @Override
    public Boolean validate(TProperty value) {
        return value != null;
    }
}
