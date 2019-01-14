package com.epam.webParsing.service.factory.abstract_factory;

import com.epam.webParsing.service.factory.factory_impl.ContributionServiceFactory;
import com.epam.webParsing.service.factory.factory_impl.GemstoneServiceFactory;
import com.epam.webParsing.service.factory.factory_interface.ServiceFactory;
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
