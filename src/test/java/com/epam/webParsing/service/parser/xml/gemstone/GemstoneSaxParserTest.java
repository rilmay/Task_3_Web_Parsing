package com.epam.webParsing.service.parser.xml.gemstone;

import com.epam.webParsing.entity.Gemstone;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class GemstoneSaxParserTest {
    private XmlParser<Gemstone> domParser;
    private FileReader fileReader;
    private File parsedFile3;
    private File parsedFile4;

    @BeforeTest
    public void init() {
        domParser = new GemstoneSaxParser();
        fileReader = FileReader.getInstance();
        parsedFile3 = fileReader.read("src/test/resources/gems/Gems3.xml");
        parsedFile4 = fileReader.read("src/test/resources/gems/Gems4.xml");
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("Gemstone@ name: Heath preciousness: Semiprecious origin: Azerbaijan " +
                "color: Teal transparency: 1.0 cuttingMethod: 12 value: 29.0", domParser.parse(parsedFile3).get(0).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals("Gemstone@ name: Xavier preciousness: Semiprecious origin: Brazil " +
                "color: Teal transparency: 32.0 cuttingMethod: 11 value: 25.0", domParser.parse(parsedFile4).get(0).toString());
    }
}
