package com.epam.webParsing.service.factory.factoryImpl;

import com.epam.webParsing.service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.service.parser.parserInterface.XmlParser;
import com.epam.webParsing.service.parser.xmlParser.gemstoneParser.GemstoneDomParser;
import com.epam.webParsing.service.parser.xmlParser.gemstoneParser.GemstoneSaxParser;
import com.epam.webParsing.service.parser.xmlParser.gemstoneParser.GemstoneStaxParser;
import com.epam.webParsing.service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.validatorImpl.XmlValidatorImpl;
import com.epam.webParsing.service.validator.xml.xmlValidatorInterface.XmlValidator;
import com.epam.webParsing.service.validator.validatorInterface.Validator;

public class GemstoneServiceFactory implements ServiceFactory {
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
                return new GemstoneDomParser();
            case SAX:
                return new GemstoneSaxParser();
            case STAX:
                return new GemstoneStaxParser();
            default:
                throw new IllegalArgumentException();
        }
    }
}
