package com.epam.webParsing.controller;

import com.epam.webParsing.entity.entity_interface.XmlEntity;
import com.epam.webParsing.entity.type.EntityType;
import com.epam.webParsing.service.factory.abstract_factory.XmlFactory;
import com.epam.webParsing.service.factory.factory_interface.ServiceFactory;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import com.epam.webParsing.service.parser.parser_xml.type.ParserType;
import com.epam.webParsing.service.validator.validator_interface.Validator;

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
