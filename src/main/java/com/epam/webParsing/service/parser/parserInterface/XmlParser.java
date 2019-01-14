package com.epam.webParsing.service.parser.parserInterface;

import com.epam.webParsing.entity.xmlEntityInterface.XmlEntity;

import java.io.File;
import java.util.List;

public interface XmlParser<T extends XmlEntity> {
    List<T> parse(File parsedFile);
}
