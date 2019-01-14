package com.epam.webParsing.service.factory.factoryImpl;

import com.epam.webParsing.service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.service.parser.parserInterface.XmlParser;
import com.epam.webParsing.service.parser.xmlParser.contributionParser.ContributionDomParser;
import com.epam.webParsing.service.parser.xmlParser.contributionParser.ContributionSaxParser;
import com.epam.webParsing.service.parser.xmlParser.contributionParser.ContributionStaxParser;
import com.epam.webParsing.service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.validatorImpl.XmlValidatorImpl;
import com.epam.webParsing.service.validator.xml.xmlValidatorInterface.XmlValidator;
import com.epam.webParsing.service.validator.validatorInterface.Validator;

public class ContributionServiceFactory implements ServiceFactory {
    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        XmlValidator validator = new XmlValidatorImpl();
        validator.setXsd(null);
        return validator;
    }

    @Override
    public XmlParser getParserByType(ParserType parserType) {
        switch (parserType) {
            case DOM:
                return new ContributionDomParser();
            case SAX:
                return new ContributionSaxParser();
            case STAX:
                return new ContributionStaxParser();
            default:
                throw new IllegalArgumentException();
        }
    }
}
