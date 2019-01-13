package com.epam.webParsing.controller;

import com.epam.webParsing.Service.factory.AbstractFactory.XmlFactory;
import com.epam.webParsing.Service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.Service.parser.ParserInterface.XmlParser;
import com.epam.webParsing.Service.parser.xmlParser.parserType.ParserType;
import com.epam.webParsing.Service.validator.validatorInterface.Validator;
import com.epam.webParsing.entity.XmlEntityInterface.XmlEntity;
import com.epam.webParsing.entity.type.EntityType;

import java.io.File;
import java.util.List;

public class MainController {
    List<XmlEntity> readFileAndReturnParsed(String path, EntityType entityType) {
        XmlFactory xmlFactory = XmlFactory.getInstance();
        ServiceFactory serviceFactory = xmlFactory.returnFactoryByType(entityType);
        File parsedFile = serviceFactory.getFileReader().read(path);
        Validator validator = serviceFactory.getXmlValidator();
        if(!validator.isValid(parsedFile)){
            throw new IllegalArgumentException("Incorrect file");
        }
        XmlParser<XmlEntity> domParser = serviceFactory.getParserByType(ParserType.DOM);
        return domParser.parse(parsedFile);
    }
}
