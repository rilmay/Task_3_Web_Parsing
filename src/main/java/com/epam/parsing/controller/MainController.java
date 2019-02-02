package com.epam.parsing.controller;

import com.epam.parsing.entity.XmlEntity;
import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.factory.ServiceFactory;
import com.epam.parsing.service.factory.abstr.XmlFactory;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class MainController {
    private static Logger logger = LogManager.getLogger(MainController.class);
    private static MainController instance = new MainController();

    public static MainController getInstance() {
        return instance;
    }

    public <T extends XmlEntity> List<T> readFileAndReturnParsed(String path, String parserType, Class<T> entityClass) {
        if (path == null || path.isEmpty() || parserType.isEmpty()) {
            logger.error("Incorrect string parameters");
            throw new IncorrectInputException("Incorrect string parameters");
        }
        XmlFactory xmlFactory = XmlFactory.getInstance();
        ServiceFactory serviceFactory = xmlFactory.getFactoryByType(entityClass);
        File parsedFile = serviceFactory.getFileReader().read(path);
        Validator validator = serviceFactory.getXmlValidator();
        if (!validator.isValid(parsedFile)) {
            logger.error("Invalid file");
            throw new IncorrectInputException("Invalid file");
        }
        XmlParser<T> parser = serviceFactory.getParserByType(parserType);
        return parser.parse(parsedFile);
    }
}
