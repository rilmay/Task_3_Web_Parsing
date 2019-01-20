package com.epam.parsing.service.factory.impl;

import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.factory.ServiceFactory;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.parser.gemstone.GemstoneDomParser;
import com.epam.parsing.service.parser.gemstone.GemstoneSaxParser;
import com.epam.parsing.service.parser.gemstone.GemstoneStaxParser;
import com.epam.parsing.service.parser.type.ParserType;
import com.epam.parsing.service.reader.FileReader;
import com.epam.parsing.service.validator.Validator;
import com.epam.parsing.service.validator.impl.XmlValidatorImpl;
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
