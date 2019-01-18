package com.epam.webParsing.service.parser;

import com.epam.webParsing.entity.XmlEntity;

import java.io.File;
import java.util.List;

public interface XmlParser<T extends XmlEntity> {
    List<T> parse(File parsedFile);
}
