package com.epam.webParsing.Service.validator.validatorInterface;

public interface Validator<T> {
    boolean isValid(T input);
}
