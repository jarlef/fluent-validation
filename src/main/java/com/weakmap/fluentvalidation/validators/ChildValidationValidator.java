package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;
import com.weakmap.fluentvalidation.Validator;

public class ChildValidationValidator<TProperty> implements PropertyValidator<TProperty> {

    private final Validator<TProperty> validator;

    public ChildValidationValidator(Validator<TProperty> validator) {
        this.validator = validator;
    }
    @Override
    public Boolean validate(TProperty value) {
        return validator.validate(value).isValid();
    }
}
