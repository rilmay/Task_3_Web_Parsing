package com.epam.webParsing.service.factory;

import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.Validator;

import java.io.File;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator<File> getXmlValidator();

    XmlParser getParserByType(String parserType);
}
