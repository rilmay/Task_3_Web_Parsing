package com.epam.webParsing.service.validator.xml.impl;

import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.XmlValidator;
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

public class XmlValidatorImpl implements XmlValidator {
    private static Logger logger = LogManager.getLogger(XmlValidatorImpl.class);
    private File xsd;

    @Override
    public void setXsd(String xsdPath) {
        if (xsdPath == null || xsdPath.isEmpty()) {
            throw new IncorrectInputException("Incorrect xsd");
        }
        FileReader fileReader = FileReader.getInstance();
        xsd = fileReader.read(xsdPath);
    }

    @Override
    public boolean isValid(File input) {
        try {
            if (input == null || !input.exists()) {
                logger.info("Incorrect parsed file");
                throw new IncorrectInputException("Incorrect parsed file");
            }
            if (xsd == null || !xsd.exists()) {
                logger.info("Xsd is not configured ");
                throw new IncorrectInputException("Xsd is not configured");
            }
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