package com.epam.webParsing.service.validator.xml.xmlValidatorInterface;

import com.epam.webParsing.service.validator.validatorInterface.Validator;

import java.io.File;

public interface XmlValidator extends Validator<File> {
    void setXsd(String xsdPath);
}
