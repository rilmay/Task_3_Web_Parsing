package com.epam.webParsing.service.factory.impl;

import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.xml.gemstone.GemstoneDomParser;
import com.epam.webParsing.service.parser.xml.gemstone.GemstoneSaxParser;
import com.epam.webParsing.service.parser.xml.gemstone.GemstoneStaxParser;
import com.epam.webParsing.service.parser.xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;
import com.epam.webParsing.service.validator.xml.XmlValidator;
import com.epam.webParsing.service.validator.xml.impl.XmlValidatorImpl;

public class GemstoneServiceFactory implements ServiceFactory {

    private static final String XSD_GEMSTONE_PATH = "src/main/resources/Gemstone.xsd";

    @Override
    public FileReader getFileReader() {
        return FileReader.getInstance();
    }

    @Override
    public Validator getXmlValidator() {
        XmlValidator validator = new XmlValidatorImpl();
        validator.setXsd(XSD_GEMSTONE_PATH);
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
