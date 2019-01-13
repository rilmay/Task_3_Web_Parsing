package com.epam.webParsing.Service.factory.factoryImpl;

import com.epam.webParsing.Service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.Service.parser.ParserInterface.XmlParser;
import com.epam.webParsing.Service.parser.xmlParser.gemstoneParser.GemstoneDomParser;
import com.epam.webParsing.Service.parser.xmlParser.gemstoneParser.GemstoneSaxParser;
import com.epam.webParsing.Service.parser.xmlParser.gemstoneParser.GemstoneStaxParser;
import com.epam.webParsing.Service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.Service.reader.FileReader;
import com.epam.webParsing.Service.validator.Xml.validatorImpl.XmlValidatorImpl;
import com.epam.webParsing.Service.validator.Xml.xmlValidatorInterface.XmlValidator;
import com.epam.webParsing.Service.validator.validatorInterface.Validator;

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
