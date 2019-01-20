package com.epam.webParsing.service.factory.impl;

import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.gemstone.GemstoneDomParser;
import com.epam.webParsing.service.parser.gemstone.GemstoneSaxParser;
import com.epam.webParsing.service.parser.gemstone.GemstoneStaxParser;
import com.epam.webParsing.service.parser.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;
import com.epam.webParsing.service.validator.impl.XmlValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class GemstoneServiceFactory implements ServiceFactory {
    private static Logger logger = LogManager.getLogger(GemstoneServiceFactory.class);

    private static final String XSD_GEMSTONE_PATH = "src/main/resources/Gemstone.xsd";

    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        return new XmlValidatorImpl(XSD_GEMSTONE_PATH);
    }

    @Override
    public XmlParser getParserByType(String parserType) {
        parserType = Optional.of(parserType).orElseThrow(() -> new IncorrectInputException("Parser type is null pointer"));
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
