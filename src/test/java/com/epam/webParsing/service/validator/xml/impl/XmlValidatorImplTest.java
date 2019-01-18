package com.epam.webParsing.service.validator.xml.impl;

import com.epam.webParsing.service.reader.FileReader;
import com.epam.webParsing.service.validator.xml.XmlValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class XmlValidatorImplTest {
    private String contributionXsdPath;
    private String gemstoneXsdPath;
    private XmlValidator validator;
    private FileReader fileReader;
    private File correctContribution;
    private File correctGemstone;
    private File incorrectGemstone;
    private File incorrectContribution;

    @BeforeTest
    public void init() {
        contributionXsdPath = "src/main/resources/Contribution.xsd";
        gemstoneXsdPath = "src/main/resources/Gemstone.xsd";
        fileReader = FileReader.getInstance();
        validator = new XmlValidatorImpl();
        correctContribution = fileReader.read("src/test/resources/banks/Banks1.xml");
        incorrectContribution = fileReader.read("src/test/resources/banks/Banks_incorrect.xml");
        correctGemstone = fileReader.read("src/test/resources/gems/Gems1.xml");
        incorrectGemstone = fileReader.read("src/test/resources/gems/Gems_incorrect.xml");
    }

    @Test
    public void testIsValidContribution() {
        validator.setXsd(contributionXsdPath);
        Assert.assertTrue(validator.isValid(correctContribution));
    }

    @Test
    public void testIsValidGemstone() {
        validator.setXsd(gemstoneXsdPath);
        Assert.assertTrue(validator.isValid(correctGemstone));
    }

    @Test
    public void testIsValidIncorrectContribution() {
        validator.setXsd(contributionXsdPath);
        Assert.assertFalse(validator.isValid(incorrectContribution));
    }

    @Test
    public void testIsValidIncorrectGemstone() {
        validator.setXsd(gemstoneXsdPath);
        Assert.assertFalse(validator.isValid(incorrectGemstone));
    }

}
