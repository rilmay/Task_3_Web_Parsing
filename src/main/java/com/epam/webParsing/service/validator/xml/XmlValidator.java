package com.epam.webParsing.service.validator.xml;

import com.epam.webParsing.service.validator.Validator;

public interface XmlValidator extends Validator {
    void setXsd(String xsdPath);
}
