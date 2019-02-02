package com.epam.parsing.service.parser.contribution;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ContributionDomParserTest {
    private XmlParser<Contribution> domParser;
    private FileReader fileReader;
    private File parsedFile1;
    private File parsedFile2;
    private File parsedFile3;
    private File parsedFile4;
    private File parsedFile5;

    @BeforeTest
    public void init() {
        domParser = new ContributionDomParser();
        fileReader = FileReader.getInstance();
        parsedFile1 = fileReader.read("src/test/resources/banks/Banks1.xml");
        parsedFile2 = fileReader.read("src/test/resources/banks/Banks2.xml");
        parsedFile3 = fileReader.read("src/test/resources/banks/Banks3.xml");
        parsedFile4 = fileReader.read("src/test/resources/banks/Banks4.xml");
        parsedFile5 = fileReader.read("src/test/resources/banks/Banks5.xml");

    }

    @Test
    public void testParse1() {
        Assert.assertEquals("Contribution@ name: Bauch, Schaefer and Lehner country: United States " +
                "type: saving depositor: Bernie Churcher accountId: 99 amountOfDeposit: 87.44 " +
                "profitability: 49.97 timeConstraints: 2 days", domParser.parse(parsedFile1).get(0).toString());
    }

    @Test
    public void testParse2() {
        Assert.assertEquals("Contribution@ name: Streich and Sons country: Indonesia type: urgent " +
                "depositor: Lewiss Bolland accountId: 21 amountOfDeposit: 16.08 profitability: 59.38 " +
                "timeConstraints: 9 months 9 days", domParser.parse(parsedFile2).get(0).toString());
    }

    @Test
    public void testParse3() {
        Assert.assertEquals("Contribution@ name: Durgan, Block and Gusikowski country: China type: calculated " +
                "depositor: Karin McKennan accountId: 54 amountOfDeposit: 99.88 profitability: 23.96 " +
                "timeConstraints: 7 days", domParser.parse(parsedFile3).get(0).toString());
    }

    @Test
    public void testParse4() {
        Assert.assertEquals("Contribution@ name: Reynolds, Stamm and Schmidt country: France type: urgent " +
                "depositor: Consuela Letham accountId: 80 amountOfDeposit: 90.9 profitability: 46.17 " +
                "timeConstraints: 2 years 4 months 6 days", domParser.parse(parsedFile4).get(0).toString());
    }

    @Test
    public void testParse5() {
        Assert.assertEquals("Contribution@ name: Weimann-Schultz country: Portugal type: saving " +
                "depositor: Heidi Stenners accountId: 54 amountOfDeposit: 75.27 profitability: 86.03 " +
                "timeConstraints: 5 months 2 days 7 hours", domParser.parse(parsedFile5).get(0).toString());
    }

}
