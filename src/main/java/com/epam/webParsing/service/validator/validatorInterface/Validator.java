package com.epam.webParsing.service.validator.validatorInterface;

public interface Validator<T> {
    boolean isValid(T input);
}
