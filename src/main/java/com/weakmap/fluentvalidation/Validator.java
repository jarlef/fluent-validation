package com.weakmap.fluentvalidation;

public interface Validator<T> {
    ValidationResult validate(T instance);
}
