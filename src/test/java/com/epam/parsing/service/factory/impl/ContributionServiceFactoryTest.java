package com.epam.parsing.service.factory.impl;

import com.epam.parsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContributionServiceFactoryTest {
    private ContributionServiceFactory contributionServiceFactory;

    @BeforeTest
    public void init() {
        contributionServiceFactory = new ContributionServiceFactory();
    }

    @Test
    public void testGetFileReader() {
        Assert.assertEquals(FileReader.getInstance().hashCode(), contributionServiceFactory.getFileReader().hashCode());
    }
}
