package com.epam.webParsing.service.parser.parser_interface;

import com.epam.webParsing.entity.entity_interface.XmlEntity;

import java.io.File;
import java.util.List;

public interface XmlParser<T extends XmlEntity> {
    List<T> parse(File parsedFile);
}
