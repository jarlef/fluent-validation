package com.github.jarlef.fluentvalidation.validators;

import com.github.jarlef.fluentvalidation.PropertyValidator;
import com.github.jarlef.fluentvalidation.Validator;
import com.github.jarlef.fluentvalidation.ValidationResult;

public class ChildValidationValidator<TProperty> extends PropertyValidator<TProperty> {

    private final Validator<TProperty> validator;
    private ValidationResult result;
    public ChildValidationValidator(Validator<TProperty> validator) {
        this.validator = validator;
    }

    @Override
    public Boolean validate(TProperty value) {
        result = validator.validate(value);
        return result.isValid();
    }

    public ValidationResult getResult() {
        return result;
    }


}
