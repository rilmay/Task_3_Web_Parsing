package com.epam.webParsing.service.validator.impl;

import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class XmlValidatorImpl implements com.epam.webParsing.service.validator.Validator {
    private static Logger logger = LogManager.getLogger(XmlValidatorImpl.class);
    private File xsd;

    public XmlValidatorImpl(String xsdPath) {
        setXsd(xsdPath);
    }

    private void setXsd(String xsdPath) {
        FileReader fileReader = FileReader.getInstance();
        xsd = fileReader.read(xsdPath);
    }

    @Override
    public boolean isValid(File input) {
        try {
            input = Optional.of(input).orElseThrow(() -> new IncorrectInputException("Incorrect parsed file"));
            xsd = Optional.of(xsd).orElseThrow(() -> new IncorrectInputException("Incorrect xsd file"));
            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(input));
            return true;
        } catch (SAXException | IOException e) {
            logger.error("Invalid file, cause: " + e.getMessage());
            return false;
        }
    }
}