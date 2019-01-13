package com.epam.webParsing.Service.parser.ParserInterface;

import com.epam.webParsing.entity.XmlEntityInterface.XmlEntity;

import java.io.File;
import java.util.List;

public interface XmlParser<T extends XmlEntity> {
    List<T> parse(File parsedFile);
}
