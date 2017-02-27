package com.github.jarlef.fluentvalidation;

public interface Validator<T> {
    ValidationResult validate(T instance);
}
