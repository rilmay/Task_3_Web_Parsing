package com.epam.webParsing.service.validator.validator_interface;

public interface Validator<T> {
    boolean isValid(T input);
}
