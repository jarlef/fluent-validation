package com.weakmap.fluentvalidation.validators;

import com.weakmap.fluentvalidation.PropertyValidator;
import com.weakmap.fluentvalidation.ValidationResult;
import com.weakmap.fluentvalidation.Validator;

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
