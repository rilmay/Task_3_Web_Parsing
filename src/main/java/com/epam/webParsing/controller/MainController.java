package com.epam.webParsing.controller;

import com.epam.webParsing.entity.XmlEntity;
import com.epam.webParsing.entity.type.EntityType;
import com.epam.webParsing.service.factory.abstr.XmlFactory;
import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.parser.xml.type.ParserType;
import com.epam.webParsing.service.validator.Validator;

import java.io.File;
import java.util.List;

public class MainController {
    public List<XmlEntity> readFileAndReturnParsed(String path, EntityType entityType) {
        XmlFactory xmlFactory = XmlFactory.getInstance();
        ServiceFactory serviceFactory = xmlFactory.getFactoryByType(entityType);
        File parsedFile = serviceFactory.getFileReader().read(path);
        Validator validator = serviceFactory.getXmlValidator();
        if (!validator.isValid(parsedFile)) {
            throw new IllegalArgumentException("Incorrect file");
        }
        XmlParser<XmlEntity> domParser = serviceFactory.getParserByType(ParserType.STAX);
        return domParser.parse(parsedFile);
    }
}
