package com.epam.webParsing.service.factory;

import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator getXmlValidator();

    XmlParser getParserByType(ParserType parserType);
}
