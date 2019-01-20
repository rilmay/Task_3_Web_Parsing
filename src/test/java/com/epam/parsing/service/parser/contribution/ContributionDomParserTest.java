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

    @BeforeTest
    public void init() {
        domParser = new ContributionDomParser();
        fileReader = FileReader.getInstance();
        parsedFile1 = fileReader.read("src/test/resources/banks/Banks1.xml");
        parsedFile2 = fileReader.read("src/test/resources/banks/Banks2.xml");
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

}
