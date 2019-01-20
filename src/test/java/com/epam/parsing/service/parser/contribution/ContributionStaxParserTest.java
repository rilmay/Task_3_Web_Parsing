package com.epam.parsing.service.parser.contribution;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.service.parser.XmlParser;
import com.epam.parsing.service.reader.FileReader;
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
        Assert.assertEquals("Contribution@ name: Weimann-Schultz country: Portugal type: saving " +
                "depositor: Heidi Stenners accountId: 54 amountOfDeposit: 75.27 profitability: 86.03 " +
                "timeConstraints: 5 months 2 days 7 hours", staxParser.parse(parsedFile5).get(0).toString());
    }

    @Test
    public void testParse4() {
        Assert.assertEquals("Contribution@ name: Buckridge-Morar country: China type: metal " +
                "depositor: Ema Jowle accountId: 93 amountOfDeposit: 23.61 profitability: 95.4 " +
                "timeConstraints: 3 days 6 hours", staxParser.parse(parsedFile6).get(0).toString());
    }
}
