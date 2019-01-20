package com.epam.parsing.service.parser;

import com.epam.parsing.entity.XmlEntity;

import java.io.File;
import java.util.List;

public interface XmlParser<T extends XmlEntity> {
    List<T> parse(File parsedFile);
}
