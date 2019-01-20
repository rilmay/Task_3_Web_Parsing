package com.epam.webParsing.service.parser.contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ContributionDomParserTest {
    private XmlParser<Contribution> domParser;
    private FileReader fileReader;
    private File parsedFile1;
    private File parsedFile2;

    @BeforeTest
    public void init() {
        domParser = new ContributionDomParser();
        fileReader = FileReader.getInstance();
        parsedFile1 = fileReader.read("src/test/resources/banks/Banks1.xml");
        parsedFile2 = fileReader.read("src/test/resources/banks/Banks2.xml");
    }

    @Test
    public void testParse1() {
        Assert.assertEquals("Contribution@ name: Rolfson, Paucek and Haag country: Indonesia type: calculated " +
                "depositor: Edwina Pearsall accountId: 14 amountOfDeposit: 56.11 profitability: 72.9 " +
                "timeConstraints: 77.0", domParser.parse(parsedFile1).get(0).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals("Contribution@ name: Reilly-Cummerata country: Afghanistan type: demand " +
                "depositor: Stanford Vedenyapin accountId: 34 amountOfDeposit: 45.54 profitability: 2.9 " +
                "timeConstraints: 83.0", domParser.parse(parsedFile2).get(0).toString());
    }

}
