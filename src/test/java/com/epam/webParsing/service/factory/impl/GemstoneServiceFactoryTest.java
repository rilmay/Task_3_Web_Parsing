package com.epam.webParsing.service.factory.impl;

import com.epam.webParsing.service.validator.xml.impl.XmlValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GemstoneServiceFactoryTest {
    private GemstoneServiceFactory gemstoneServiceFactory = new GemstoneServiceFactory();

    @BeforeTest
    public void init() {
        gemstoneServiceFactory = new GemstoneServiceFactory();
    }

    @Test
    public void testGetXmlValidator() {
        Assert.assertEquals(XmlValidatorImpl.class, gemstoneServiceFactory.getXmlValidator().getClass());
    }
}
