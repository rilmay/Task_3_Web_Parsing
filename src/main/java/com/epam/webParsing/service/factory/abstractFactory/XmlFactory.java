package com.epam.webParsing.service.factory.abstractFactory;

import com.epam.webParsing.service.factory.factoryImpl.ContributionServiceFactory;
import com.epam.webParsing.service.factory.factoryImpl.GemstoneServiceFactory;
import com.epam.webParsing.service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.entity.type.EntityType;

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
                throw new IllegalArgumentException();
        }
    }
}
