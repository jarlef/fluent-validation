package com.github.jarlef.fluentvalidation;

import com.github.jarlef.fluentvalidation.validators.ExpressionValidator;
import com.github.jarlef.fluentvalidation.validators.MaxLengthValidator;
import com.github.jarlef.fluentvalidation.validators.MinLengthValidator;
import com.github.jarlef.fluentvalidation.validators.NotNullValidator;
import com.github.jarlef.fluentvalidation.validators.ChildValidationValidator;
import com.github.jarlef.fluentvalidation.validators.NotEmptyValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class PropertyRuleImpl<T, TProperty> implements PropertyRuleWithValidator<T, TProperty>, ValidatePropertyRules<T> {

    private final Function<T, TProperty> property;
    private final List<PropertyValidator<TProperty>> propertyValidators;
    private String propertyName;

    PropertyRuleImpl(Function<T, TProperty> property, String propertyName) {
        this.property =  property;
        this.propertyName =  propertyName;
        this.propertyValidators = new ArrayList<>();
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> must(Function<TProperty, Boolean> expression) {
        propertyValidators.add(new ExpressionValidator<>(expression));
        return this;
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> notNull() {
        propertyValidators.add(new NotNullValidator<>());
        return this;
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> notEmpty() {
       propertyValidators.add(new NotEmptyValidator<>());
        return this;
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> minLength(int length) {
        propertyValidators.add(new MinLengthValidator<>(length));
        return this;
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> maxLength(int length) {
        propertyValidators.add(new MaxLengthValidator<>(length));
        return this;
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> using(Validator<TProperty> validator) {
        propertyValidators.add(new ChildValidationValidator<>(validator));
        return this;
    }

    @Override
    public PropertyRuleWithValidator<T, TProperty> withMessage(String message) {
        propertyValidators.get(propertyValidators.size()-1).setMessage(message);
        return this;
    }


    @SuppressWarnings("all")
    @Override
    public ValidationResult validate(T instance) {

        String propertyName = this.propertyName;

        if(propertyName == null) {
            Recorder<T> recorder = (Recorder<T>) ReflectionHelper.createProxy(instance.getClass());
            this.property.apply(recorder.getObject());
            propertyName = recorder.getCurrentPropertyName();
        }

        TProperty value = this.property.apply(instance);
        List<ValidationError> errors = new ArrayList<>();

        for(PropertyValidator<TProperty> propertyValidator : propertyValidators) {
            Boolean isValid = propertyValidator.validate(value);

            if(isValid) {
                continue;
            }

            if(propertyValidator instanceof ChildValidationValidator) {
                return ((ChildValidationValidator<TProperty>) propertyValidator).getResult();
            } else {
                errors.add(new ValidationError(propertyName, propertyValidator.getFormattedMessage(propertyName, value)));
                return ValidationResult.create(errors.toArray(new ValidationError[0]));
            }
        }

        return ValidationResult.create();
    }



}
