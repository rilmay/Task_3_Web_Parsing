package com.epam.parsing.service.factory.abstr;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.service.factory.impl.ContributionServiceFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XmlFactoryTest {
    private XmlFactory xmlFactory;

    @BeforeTest
    public void init() {
        xmlFactory = XmlFactory.getInstance();
    }

    @Test
    public void testGetFactoryByType() {
        Assert.assertEquals(ContributionServiceFactory.class, xmlFactory.getFactoryByType(Contribution.class).getClass());
    }
}
