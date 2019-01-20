package com.epam.parsing.service.factory;

import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.reader.FileReader;
import com.epam.parsing.service.validator.Validator;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator getXmlValidator();

    XmlParser getParserByType(String parserType);
}
