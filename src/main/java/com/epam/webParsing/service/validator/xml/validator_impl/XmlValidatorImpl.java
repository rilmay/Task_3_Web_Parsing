package com.epam.webParsing.service.validator.xml.validator_impl;

import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.validator_Interface.XmlValidator;

import java.io.File;

public class XmlValidatorImpl implements XmlValidator {
    private File xsd;

    @Override
    public void setXsd(String xsdPath) {
        FileReader fileReader = FileReader.getInstance();
        xsd = fileReader.read(xsdPath);
    }

    @Override
    public boolean isValid(File parsedFile) {
        return false;
    }
}
