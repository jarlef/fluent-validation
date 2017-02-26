package com.weakmap.fluentvalidation;

interface ValidatePropertyRules<T> {
    ValidationResult validate(T instance);
}
