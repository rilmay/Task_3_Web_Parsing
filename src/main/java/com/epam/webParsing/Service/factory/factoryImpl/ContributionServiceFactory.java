package com.epam.webParsing.Service.factory.factoryImpl;

import com.epam.webParsing.Service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.Service.parser.ParserInterface.XmlParser;
import com.epam.webParsing.Service.parser.xmlParser.contributionParser.ContributionDomParser;
import com.epam.webParsing.Service.parser.xmlParser.contributionParser.ContributionSaxParser;
import com.epam.webParsing.Service.parser.xmlParser.contributionParser.ContributionStaxParser;
import com.epam.webParsing.Service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.Service.reader.FileReader;
import com.epam.webParsing.Service.validator.Xml.validatorImpl.XmlValidatorImpl;
import com.epam.webParsing.Service.validator.validatorInterface.Validator;

public class ContributionServiceFactory implements ServiceFactory {
    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        Validator validator = new XmlValidatorImpl();
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
                return null;
        }
    }
}
