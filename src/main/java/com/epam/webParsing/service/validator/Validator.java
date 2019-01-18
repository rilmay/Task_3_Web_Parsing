package com.epam.webParsing.service.validator;

public interface Validator<T> {
    boolean isValid(T input);
}
