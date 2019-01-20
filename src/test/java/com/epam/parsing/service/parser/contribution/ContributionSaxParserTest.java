package com.epam.parsing.service.parser.contribution;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.reader.FileReader;
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
        Assert.assertEquals("Contribution@ name: Durgan, Block and Gusikowski country: China type: calculated " +
                "depositor: Karin McKennan accountId: 54 amountOfDeposit: 99.88 profitability: 23.96 " +
                "timeConstraints: 7 days", saxParser.parse(parsedFile3).get(0).toString());
    }

    @Test
    public void testParse4() {
        Assert.assertEquals("Contribution@ name: Reynolds, Stamm and Schmidt country: France type: urgent " +
                "depositor: Consuela Letham accountId: 80 amountOfDeposit: 90.9 profitability: 46.17 " +
                "timeConstraints: 2 years 4 months 6 days", saxParser.parse(parsedFile4).get(0).toString());
    }
}
