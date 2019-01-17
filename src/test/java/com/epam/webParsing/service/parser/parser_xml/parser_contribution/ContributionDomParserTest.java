package com.epam.webParsing.service.parser.parser_xml.parser_contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import com.epam.webParsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ContributionDomParserTest {
    private FileReader fileReader;
    private XmlParser<Contribution> contributionXmlParser;
    private File parsedFile1;
    private File parsedFile2;
    private File parsedFile3;
    private File parsedFile4;
    private File parsedFile5;
    private File parsedFile6;



    @BeforeTest
    public void init() {
        fileReader = FileReader.getInstance();
        contributionXmlParser = new ContributionDomParser();
        parsedFile1 = fileReader.read("src/test/resources/banks (1).xml");
        parsedFile2 = fileReader.read("src/test/resources/banks (2).xml");
        parsedFile3 = fileReader.read("src/test/resources/banks (3).xml");
        parsedFile4 = fileReader.read("src/test/resources/banks (4).xml");
        parsedFile5 = fileReader.read("src/test/resources/banks (5).xml");
        parsedFile6 = fileReader.read("src/test/resources/banks (6).xml");
    }

    @Test
    public void testParse(){
        List<Contribution> contributions = contributionXmlParser.parse(parsedFile1);
        Assert.assertEquals("Contribution@ name: Rolfson, Paucek and Haag country: Indonesia type: calculated" +
                " depositor: Edwina Pearsall accountId: 14 amountOfDeposit: 56.11 profitability: 72.9 " +
                "timeConstraints: 77.0",contributions.get(0).toString());
    }
}
