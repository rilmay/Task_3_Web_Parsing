package com.epam.webParsing.service.parser.xml.gemstone;

import com.epam.webParsing.entity.Gemstone;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class GemstoneStaxParserTest {
    private XmlParser<Gemstone> domParser;
    private FileReader fileReader;
    private File parsedFile5;
    private File parsedFile6;

    @BeforeTest
    public void init() {
        domParser = new GemstoneStaxParser();
        fileReader = FileReader.getInstance();
        parsedFile5 = fileReader.read("src/test/resources/gems/Gems5.xml");
        parsedFile6 = fileReader.read("src/test/resources/gems/Gems6.xml");
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("Gemstone@ name: Billy preciousness: Precious origin: Finland " +
                "color: Red transparency: 45.0 cuttingMethod: 11 value: 96.0", domParser.parse(parsedFile5).get(0).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals("Gemstone@ name: Hertha preciousness: semiprecious origin: China color: Turquoise " +
                "transparency: 47.0 cuttingMethod: 11 value: 85.0", domParser.parse(parsedFile6).get(0).toString());
    }
}
