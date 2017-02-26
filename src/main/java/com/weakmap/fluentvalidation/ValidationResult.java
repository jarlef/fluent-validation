package com.weakmap.fluentvalidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationResult {

    private final ValidationError[] errors;

    private ValidationResult() {
        this.errors = new ValidationError[0];
    }

    private ValidationResult(ValidationError[] errors) {
        this.errors = errors;
    }

    public boolean isValid() {
        return errors.length == 0;
    }

    public ValidationError[] getErrors() {
        return errors;
    }

    static ValidationResult create() {
        return new ValidationResult();
    }

    static ValidationResult create(ValidationError[] errors) {
        return new ValidationResult(errors);
    }

    static ValidationResult merge(ValidationResult resultA, ValidationResult resultB)
    {
        List<ValidationError> errors = new ArrayList<>();
        Arrays.stream(resultA.getErrors()).forEach(errors::add);
        Arrays.stream(resultB.getErrors()).forEach(errors::add);

        return new ValidationResult(errors.toArray(new ValidationError[0]));


    }

}
