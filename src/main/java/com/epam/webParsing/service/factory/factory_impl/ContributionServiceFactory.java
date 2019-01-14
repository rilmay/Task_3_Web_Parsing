package com.epam.webParsing.service.factory.factory_impl;

import com.epam.webParsing.service.factory.factory_interface.ServiceFactory;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import com.epam.webParsing.service.parser.parser_xml.parser_contribution.ContributionDomParser;
import com.epam.webParsing.service.parser.parser_xml.parser_contribution.ContributionSaxParser;
import com.epam.webParsing.service.parser.parser_xml.parser_contribution.ContributionStaxParser;
import com.epam.webParsing.service.parser.parser_xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.validator_impl.XmlValidatorImpl;
import com.epam.webParsing.service.validator.xml.validator_Interface.XmlValidator;
import com.epam.webParsing.service.validator.validator_interface.Validator;

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
