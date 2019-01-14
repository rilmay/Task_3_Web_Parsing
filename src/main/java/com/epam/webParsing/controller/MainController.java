package com.epam.webParsing.controller;

import com.epam.webParsing.service.factory.abstractFactory.XmlFactory;
import com.epam.webParsing.service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.service.parser.parserInterface.XmlParser;
import com.epam.webParsing.service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.service.validator.validatorInterface.Validator;
import com.epam.webParsing.entity.xmlEntityInterface.XmlEntity;
import com.epam.webParsing.entity.type.EntityType;

import java.io.File;
import java.util.List;

public class MainController {
    List<XmlEntity> readFileAndReturnParsed(String path, EntityType entityType) {
        XmlFactory xmlFactory = XmlFactory.getInstance();
        ServiceFactory serviceFactory = xmlFactory.getFactoryByType(entityType);
        File parsedFile = serviceFactory.getFileReader().read(path);
        Validator validator = serviceFactory.getXmlValidator();
        if (!validator.isValid(parsedFile)) {
            throw new IllegalArgumentException("Incorrect file");
        }
        XmlParser<XmlEntity> domParser = serviceFactory.getParserByType(ParserType.DOM);
        return domParser.parse(parsedFile);
    }
}
