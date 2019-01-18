package com.epam.webParsing.service.parser.xml.contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ContributionStaxParserTest {
    private XmlParser<Contribution> staxParser;
    private FileReader fileReader;
    private File parsedFile5;
    private File parsedFile6;

    @BeforeTest
    public void init() {
        staxParser = new ContributionStaxParser();
        fileReader = FileReader.getInstance();
        parsedFile5 = fileReader.read("src/test/resources/banks/Banks5.xml");
        parsedFile6 = fileReader.read("src/test/resources/banks/Banks6.xml");
    }

    @Test
    public void testParse3() {
        Assert.assertEquals("Contribution@ name: Nikolaus-Johnson country: Philippines type: accumulative " +
                "depositor: Salvatore Weatherill accountId: 1 amountOfDeposit: 80.67 profitability: 70.2 " +
                "timeConstraints: 24.0", staxParser.parse(parsedFile5).get(0).toString());
    }

    @Test
    public void testParse4() {
        Assert.assertEquals("Contribution@ name: Kessler and Sons country: Malaysia type: accumulative " +
                "depositor: Alisha Pennini accountId: 17 amountOfDeposit: 90.41 profitability: 90.7 " +
                "timeConstraints: 51.0", staxParser.parse(parsedFile6).get(0).toString());
    }
}
