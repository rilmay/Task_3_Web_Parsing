package com.epam.parsing.service.parser.gemstone;

import com.epam.parsing.entity.Gemstone;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class GemstoneSaxParserTest {
    private XmlParser<Gemstone> parser;
    private FileReader fileReader;
    private File parsedFile1;
    private File parsedFile2;
    private File parsedFile3;
    private File parsedFile4;
    private File parsedFile5;

    @BeforeTest
    public void init() {
        parser = new GemstoneSaxParser();
        fileReader = FileReader.getInstance();
        parsedFile1 = fileReader.read("src/test/resources/gems/Gems1.xml");
        parsedFile2 = fileReader.read("src/test/resources/gems/Gems2.xml");
        parsedFile3 = fileReader.read("src/test/resources/gems/Gems3.xml");
        parsedFile4 = fileReader.read("src/test/resources/gems/Gems4.xml");
        parsedFile5 = fileReader.read("src/test/resources/gems/Gems5.xml");
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("Gemstone@ name: Margeaux preciousness: semiprecious origin: Luxembourg " +
                "color: Pink transparency: 89.0 cuttingMethod: 10 value: 18.0", parser.parse(parsedFile1).get(0).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals("Gemstone@ name: Dionisio preciousness: precious origin: Sweden color: Violet" +
                " transparency: 84.0 cuttingMethod: 7 value: 8.0", parser.parse(parsedFile2).get(0).toString());
    }

    @Test
    public void testParse3() {
        Assert.assertEquals("Gemstone@ name: Heath preciousness: Semiprecious origin: Azerbaijan " +
                "color: Teal transparency: 1.0 cuttingMethod: 12 value: 29.0", parser.parse(parsedFile3).get(0).toString());
    }

    @Test
    public void testParse4() {
        Assert.assertEquals("Gemstone@ name: Xavier preciousness: Semiprecious origin: Brazil " +
                "color: Teal transparency: 32.0 cuttingMethod: 11 value: 25.0", parser.parse(parsedFile4).get(0).toString());
    }

    @Test
    public void testParse5() {
        Assert.assertEquals("Gemstone@ name: Billy preciousness: Precious origin: Finland " +
                "color: Red transparency: 45.0 cuttingMethod: 11 value: 96.0", parser.parse(parsedFile5).get(0).toString());
    }
}
