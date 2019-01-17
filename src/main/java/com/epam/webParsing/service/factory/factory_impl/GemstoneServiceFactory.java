package com.epam.webParsing.service.factory.factory_impl;

import com.epam.webParsing.service.factory.factory_interface.ServiceFactory;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import com.epam.webParsing.service.parser.parser_xml.parser_gemstone.GemstoneDomParser;
import com.epam.webParsing.service.parser.parser_xml.parser_gemstone.GemstoneSaxParser;
import com.epam.webParsing.service.parser.parser_xml.parser_gemstone.GemstoneStaxParser;
import com.epam.webParsing.service.parser.parser_xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.validator_interface.Validator;
import com.epam.webParsing.service.validator.xml.validator_Interface.XmlValidator;
import com.epam.webParsing.service.validator.xml.validator_impl.XmlValidatorImpl;

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