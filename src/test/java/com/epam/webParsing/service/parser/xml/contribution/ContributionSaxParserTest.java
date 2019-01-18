package com.epam.webParsing.service.parser.xml.contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ContributionSaxParserTest {
    private XmlParser<Contribution> saxParser;
    private FileReader fileReader;
    private File parsedFile3;
    private File parsedFile4;

    @BeforeTest
    public void init() {
        saxParser = new ContributionSaxParser();
        fileReader = FileReader.getInstance();
        parsedFile3 = fileReader.read("src/test/resources/banks/Banks3.xml");
        parsedFile4 = fileReader.read("src/test/resources/banks/Banks4.xml");
    }

    @Test
    public void testParse3() {
        Assert.assertEquals("Contribution@ name: Nolan-Olson country: Indonesia type: urgent " +
                "depositor: Antonie Oliveti accountId: 44 amountOfDeposit: 58.09 profitability: 3.4 " +
                "timeConstraints: 36.0", saxParser.parse(parsedFile3).get(0).toString());
    }

    @Test
    public void testParse4() {
        Assert.assertEquals("Contribution@ name: Kris, Von and Becker country: Nigeria type: accumulative " +
                "depositor: Gerry Stucksbury accountId: 32 amountOfDeposit: 82.85 profitability: 38.4 " +
                "timeConstraints: 5.0", saxParser.parse(parsedFile4).get(0).toString());
    }
}
