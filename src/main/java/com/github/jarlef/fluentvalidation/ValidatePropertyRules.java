package com.github.jarlef.fluentvalidation;

interface ValidatePropertyRules<T> {
    ValidationResult validate(T instance);
}
