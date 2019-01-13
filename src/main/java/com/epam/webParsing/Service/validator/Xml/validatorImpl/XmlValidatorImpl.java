package com.epam.webParsing.Service.validator.Xml.validatorImpl;

import com.epam.webParsing.Service.reader.FileReader;
import com.epam.webParsing.Service.validator.Xml.xmlValidatorInterface.XmlValidator;

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
