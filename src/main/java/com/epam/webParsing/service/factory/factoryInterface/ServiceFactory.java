package com.epam.webParsing.service.factory.factoryInterface;

import com.epam.webParsing.service.parser.parserInterface.XmlParser;
import com.epam.webParsing.service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.validatorInterface.Validator;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator getXmlValidator();

    XmlParser getParserByType(ParserType parserType);
}
