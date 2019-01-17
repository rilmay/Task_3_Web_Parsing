package com.epam.webParsing.service.validator.xml.validator_impl;

import com.epam.webParsing.service.parser.parser_xml.parser_gemstone.GemstoneDomParser;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.validator_Interface.XmlValidator;
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
    private static Logger logger = LogManager.getLogger(GemstoneDomParser.class.getName());
    private File xsd;

    @Override
    public void setXsd(String xsdPath) {
        FileReader fileReader = FileReader.getInstance();
        xsd = fileReader.read(xsdPath);
    }

    @Override
    public boolean isValid(File parsedFile) {
        try {
            if (!parsedFile.exists()) {
                logger.info("File don`t exist " + parsedFile.getPath());
            }
            if (!xsd.exists()) {
                logger.info("Xsd is not configured " + xsd.getPath());
            }

            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(parsedFile));
            return true;
        } catch (SAXException | IOException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
