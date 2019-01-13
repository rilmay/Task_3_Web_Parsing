package com.epam.webParsing.Service.factory.factoryImpl;

import com.epam.webParsing.Service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.Service.parser.ParserInterface.XmlParser;
import com.epam.webParsing.Service.parser.xmlParser.GemstoneParser.GemstoneDomParser;
import com.epam.webParsing.Service.parser.xmlParser.GemstoneParser.GemstoneSaxParser;
import com.epam.webParsing.Service.parser.xmlParser.GemstoneParser.GemstoneStaxParser;
import com.epam.webParsing.Service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.Service.reader.FileReader;
import com.epam.webParsing.Service.validator.Xml.XmlValidatorInterface.XmlValidator;
import com.epam.webParsing.Service.validator.Xml.validatorImpl.XmlValidatorImpl;
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
                return null;
        }
    }
}
