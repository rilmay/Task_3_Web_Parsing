package com.epam.webParsing.Service.factory.factoryInterface;

import com.epam.webParsing.Service.parser.ParserInterface.XmlParser;
import com.epam.webParsing.Service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.Service.reader.FileReader;
import com.epam.webParsing.Service.validator.validatorInterface.Validator;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator getXmlValidator();

    XmlParser getParserByType(ParserType parserType);
}
