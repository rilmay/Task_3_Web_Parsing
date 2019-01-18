package com.epam.webParsing.service.factory.impl;

import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.xml.contribution.ContributionDomParser;
import com.epam.webParsing.service.parser.xml.contribution.ContributionSaxParser;
import com.epam.webParsing.service.parser.xml.contribution.ContributionStaxParser;
import com.epam.webParsing.service.parser.xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;
import com.epam.webParsing.service.validator.xml.XmlValidator;
import com.epam.webParsing.service.validator.xml.impl.XmlValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContributionServiceFactory implements ServiceFactory {
    private static Logger logger = LogManager.getLogger(ContributionServiceFactory.class);
    private final String CONTRIBUTION_XSD_PATH = "src/main/resources/Contribution.xsd";

    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        XmlValidator validator = new XmlValidatorImpl();
        validator.setXsd(CONTRIBUTION_XSD_PATH);
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
