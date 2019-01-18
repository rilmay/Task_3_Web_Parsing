package com.epam.webParsing.service.parser.xml.gemstone;

import com.epam.webParsing.entity.Gemstone;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class GemstoneDomParserTest {
    private XmlParser<Gemstone> domParser;
    private FileReader fileReader;
    private File parsedFile1;
    private File parsedFile2;

    @BeforeTest
    public void init() {
        domParser = new GemstoneDomParser();
        fileReader = FileReader.getInstance();
        parsedFile1 = fileReader.read("src/test/resources/gems/Gems1.xml");
        parsedFile2 = fileReader.read("src/test/resources/gems/Gems2.xml");
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("Gemstone@ name: Margeaux preciousness: semiprecious origin: Luxembourg " +
                "color: Pink transparency: 89.0 cuttingMethod: 10 value: 18.0", domParser.parse(parsedFile1).get(0).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals("Gemstone@ name: Dionisio preciousness: precious origin: Sweden color: Violet" +
                " transparency: 84.0 cuttingMethod: 7 value: 8.0", domParser.parse(parsedFile2).get(0).toString());
    }
}
