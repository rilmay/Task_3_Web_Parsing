package com.epam.webParsing.service.factory.abstr;

import com.epam.webParsing.entity.type.EntityType;
import com.epam.webParsing.service.factory.impl.ContributionServiceFactory;
import com.epam.webParsing.service.factory.impl.GemstoneServiceFactory;
import com.epam.webParsing.service.factory.ServiceFactory;

public class XmlFactory {
    private static XmlFactory instance = new XmlFactory();
    private GemstoneServiceFactory gemstoneServiceFactory = new GemstoneServiceFactory();
    private ContributionServiceFactory contributionServiceFactory = new ContributionServiceFactory();

    public static XmlFactory getInstance() {
        return instance;
    }

    public ServiceFactory getFactoryByType(EntityType type) {
        switch (type) {
            case GEMSTONE:
                return gemstoneServiceFactory;
            case CONTRIBUTION:
                return contributionServiceFactory;
            default:
                throw new IllegalArgumentException("Wrong factory type");
        }
    }
}
