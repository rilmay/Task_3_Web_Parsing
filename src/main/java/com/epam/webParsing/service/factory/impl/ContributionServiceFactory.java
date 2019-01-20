package com.epam.webParsing.service.factory.impl;

import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.contribution.ContributionDomParser;
import com.epam.webParsing.service.parser.contribution.ContributionSaxParser;
import com.epam.webParsing.service.parser.contribution.ContributionStaxParser;
import com.epam.webParsing.service.parser.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;
import com.epam.webParsing.service.validator.impl.XmlValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ContributionServiceFactory implements ServiceFactory {
    private static Logger logger = LogManager.getLogger(ContributionServiceFactory.class);
    private final String CONTRIBUTION_XSD_PATH = "src/main/resources/Contribution.xsd";

    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        return new XmlValidatorImpl(CONTRIBUTION_XSD_PATH);
    }

    @Override
    public XmlParser getParserByType(String parserType) {
        String type = Optional.of(parserType).orElse("DOM");
        switch (ParserType.valueOf(type.toUpperCase())) {
            case DOM:
                return new ContributionDomParser();
            case SAX:
                return new ContributionSaxParser();
            case STAX:
                return new ContributionStaxParser();
            default:
                logger.error("Incorrect parser type");
                throw new IncorrectInputException("Incorrect parser type");
        }
    }
}
