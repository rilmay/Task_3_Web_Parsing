package com.epam.webParsing.service.factory.abstr;

import com.epam.webParsing.entity.XmlEntity;
import com.epam.webParsing.entity.type.EntityType;
import com.epam.webParsing.exception.IncorrectInputException;
import com.epam.webParsing.service.factory.ServiceFactory;
import com.epam.webParsing.service.factory.impl.ContributionServiceFactory;
import com.epam.webParsing.service.factory.impl.GemstoneServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XmlFactory {
    private static Logger logger = LogManager.getLogger(XmlFactory.class);
    private static XmlFactory instance = new XmlFactory();
    private GemstoneServiceFactory gemstoneServiceFactory = new GemstoneServiceFactory();
    private ContributionServiceFactory contributionServiceFactory = new ContributionServiceFactory();

    public static XmlFactory getInstance() {
        return instance;
    }

    public <T extends XmlEntity> ServiceFactory getFactoryByType(Class<T> entityClass) {
        String type = entityClass.getName()
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
