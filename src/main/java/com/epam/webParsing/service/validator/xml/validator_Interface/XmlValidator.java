package com.epam.webParsing.service.validator.xml.validator_Interface;

import com.epam.webParsing.service.validator.validator_interface.Validator;

import java.io.File;

public interface XmlValidator extends Validator<File> {
    void setXsd(String xsdPath);
}
