package com.epam.webParsing.Service.validator.Xml.xmlValidatorInterface;

import com.epam.webParsing.Service.validator.validatorInterface.Validator;

import java.io.File;

public interface XmlValidator extends Validator<File> {
    void setXsd(String xsdPath);
}
