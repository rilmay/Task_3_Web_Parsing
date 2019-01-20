package com.epam.parsing.controller;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.entity.Gemstone;
import com.epam.parsing.exception.IncorrectInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainControllerTest {
    private MainController mainController;
    private String contributionFilePath;
    private String gemstoneFilePath;
    private String incorrectContributionPath;

    @BeforeTest
    public void init() {
        mainController = MainController.getInstance();
        contributionFilePath = "src/test/resources/banks/Banks1.xml";
        gemstoneFilePath = "src/test/resources/gems/Gems1.xml";
        incorrectContributionPath = "src/test/resources/banks/Banks_incorrect.xml";
    }

    @Test
    public void testReadFileAndReturnParsedContribution() {
        String expected = mainController.readFileAndReturnParsed(contributionFilePath, "dom", Contribution.class)
                .get(0).toString();
        Assert.assertEquals("Contribution@ name: Rolfson, Paucek and Haag country: Indonesia type: calculated " +
                "depositor: Edwina Pearsall accountId: 14 amountOfDeposit: 56.11 " +
                "profitability: 72.9 timeConstraints: 77.0", expected);
    }

    @Test
    public void testReadFileAndReturnParsedGemstone() {
        String expected = mainController.readFileAndReturnParsed(gemstoneFilePath, "sax", Gemstone.class)
                .get(0).toString();
        Assert.assertEquals("Gemstone@ name: Margeaux preciousness: semiprecious origin: Luxembourg " +
                "color: Pink transparency: 89.0 cuttingMethod: 10 value: 18.0", expected);
    }

    @Test(expectedExceptions = IncorrectInputException.class)
    public void testReadFileAndReturnParsedFailed() {
        String expected = mainController.readFileAndReturnParsed(incorrectContributionPath, "dom", Contribution.class)
                .get(0).toString();
        Assert.assertEquals("", expected);
    }
}
