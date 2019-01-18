package com.epam.webParsing.service.validator.xml;

import com.epam.webParsing.service.validator.Validator;

import java.io.File;

public interface XmlValidator extends Validator<File> {
    void setXsd(String xsdPath);
}
