package com.epam.parsing.service.factory;

import com.epam.parsing.entity.XmlEntity;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.reader.FileReader;
import com.epam.parsing.service.validator.Validator;
import com.epam.parsing.service.writer.XMLWriter;

public interface ServiceFactory {
    FileReader getFileReader();

    Validator getXmlValidator();

    XmlParser getParserByType(String parserType);

    XMLWriter<? extends XmlEntity> getWriter();
}
