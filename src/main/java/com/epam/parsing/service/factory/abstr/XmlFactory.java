package com.epam.parsing.service.factory.abstr;

import com.epam.parsing.entity.XmlEntity;
import com.epam.parsing.entity.type.EntityType;
import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.factory.ServiceFactory;
import com.epam.parsing.service.factory.impl.ContributionServiceFactory;
import com.epam.parsing.service.factory.impl.GemstoneServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class XmlFactory {
    private static Logger logger = LogManager.getLogger(XmlFactory.class);
    private static XmlFactory instance = new XmlFactory();
    private GemstoneServiceFactory gemstoneServiceFactory = new GemstoneServiceFactory();
    private ContributionServiceFactory contributionServiceFactory = new ContributionServiceFactory();

    public static XmlFactory getInstance() {
        return instance;
    }

    public <T extends XmlEntity> ServiceFactory getFactoryByType(Class<T> entityClass) {
        Class inputClass = Optional.of(entityClass).orElseThrow(() -> new IncorrectInputException("Incorrect class"));
        String type = inputClass.getName()
                .replaceAll("\\w+\\.", "").toUpperCase();
        EntityType entityType = EntityType.valueOf(type);

        switch (entityType) {
            case GEMSTONE:
                return gemstoneServiceFactory;
            case CONTRIBUTION:
                return contributionServiceFactory;
            default:
                logger.error("Incorrect entity type");
                throw new IncorrectInputException("Incorrect entity type");
        }
    }
}
