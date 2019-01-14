package com.epam.webParsing.service.factory.factory_interface;

import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import com.epam.webParsing.service.parser.parser_xml.type.ParserType;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.validator_interface.Validator;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator getXmlValidator();

    XmlParser getParserByType(ParserType parserType);
}
