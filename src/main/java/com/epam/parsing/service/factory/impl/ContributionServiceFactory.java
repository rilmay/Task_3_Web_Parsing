package com.epam.parsing.service.factory.impl;

import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.factory.ServiceFactory;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.parser.contribution.ContributionDomParser;
import com.epam.parsing.service.parser.contribution.ContributionSaxParser;
import com.epam.parsing.service.parser.contribution.ContributionStaxParser;
import com.epam.parsing.service.parser.type.ParserType;
import com.epam.parsing.service.reader.FileReader;
import com.epam.parsing.service.validator.Validator;
import com.epam.parsing.service.validator.impl.XmlValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ContributionServiceFactory implements ServiceFactory {
    private static Logger logger = LogManager.getLogger(ContributionServiceFactory.class);
    private static final String XSD_CONTRIBUTION_PATH = "src/main/resources/Contribution.xsd";

    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        return new XmlValidatorImpl(XSD_CONTRIBUTION_PATH);
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
