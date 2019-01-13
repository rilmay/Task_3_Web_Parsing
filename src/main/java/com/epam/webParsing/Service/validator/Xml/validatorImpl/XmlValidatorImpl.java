package com.epam.webParsing.Service.validator.Xml.validatorImpl;

import com.epam.webParsing.Service.validator.Xml.XmlValidatorInterface.XmlValidator;

import java.io.File;

public class XmlValidatorImpl implements XmlValidator {
    @Override
    public void setXsd(String xsdPath) {
    }

    @Override
    public boolean isValid(File parsedFile) {
        return false;
    }
}
