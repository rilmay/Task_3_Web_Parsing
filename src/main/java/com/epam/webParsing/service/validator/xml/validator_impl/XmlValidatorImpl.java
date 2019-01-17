package com.epam.webParsing.service.validator.xml.validator_impl;

import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.validator_Interface.XmlValidator;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidatorImpl implements XmlValidator {
    private File xsd;

    @Override
    public void setXsd(String xsdPath) {
        FileReader fileReader = FileReader.getInstance();
        xsd = fileReader.read(xsdPath);
    }

    @Override
    public boolean isValid(File parsedFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(parsedFile));
        } catch (IOException | SAXException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
