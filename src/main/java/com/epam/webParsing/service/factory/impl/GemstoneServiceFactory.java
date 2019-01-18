package com.epam.webParsing.service.factory.impl;

import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.xml.gemstone.GemstoneDomParser;
import com.epam.webParsing.service.parser.xml.gemstone.GemstoneSaxParser;
import com.epam.webParsing.service.parser.xml.gemstone.GemstoneStaxParser;
import com.epam.webParsing.service.parser.xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;
import com.epam.webParsing.service.validator.xml.XmlValidator;
import com.epam.webParsing.service.validator.xml.impl.XmlValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GemstoneServiceFactory implements ServiceFactory {
    private static Logger logger = LogManager.getLogger(GemstoneServiceFactory.class);

    private static final String XSD_GEMSTONE_PATH = "src/main/resources/Gemstone.xsd";

    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        XmlValidator validator = new XmlValidatorImpl();
        validator.setXsd(XSD_GEMSTONE_PATH);
        return validator;
    }

    @Override
    public XmlParser getParserByType(String parserType) {
        if (parserType == null || parserType.isEmpty()) {
            logger.error("Incorrect parser type");
            throw new IncorrectInputException("Incorrect parser type");
        }
        switch (ParserType.valueOf(parserType.toUpperCase())) {
            case DOM:
                return new GemstoneDomParser();
            case SAX:
                return new GemstoneSaxParser();
            case STAX:
                return new GemstoneStaxParser();
            default:
                logger.error("Incorrect parser type");
                throw new IncorrectInputException("Incorrect parser type");
        }
    }
}
