package com.epam.webParsing.Service.factory.AbstractFactory;

import com.epam.webParsing.Service.factory.factoryImpl.ContributionServiceFactory;
import com.epam.webParsing.Service.factory.factoryImpl.GemstoneServiceFactory;
import com.epam.webParsing.Service.factory.factoryInterface.ServiceFactory;
import com.epam.webParsing.entity.type.EntityType;

public class XmlFactory {
    private static XmlFactory instance = new XmlFactory();
    private GemstoneServiceFactory gemstoneServiceFactory = new GemstoneServiceFactory();
    private ContributionServiceFactory contributionServiceFactory = new ContributionServiceFactory();

    public static XmlFactory getInstance() {
        return instance;
    }

    public ServiceFactory returnFactoryByType(EntityType type) {
        switch (type) {
            case GEMSTONE:
                return gemstoneServiceFactory;
            case CONTRIBUTION:
                return contributionServiceFactory;
            default:
                return null;
        }
    }
}
