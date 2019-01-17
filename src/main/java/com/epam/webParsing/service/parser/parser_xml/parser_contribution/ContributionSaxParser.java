package com.epam.webParsing.service.parser.parser_xml.parser_contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ContributionSaxParser implements XmlParser<Contribution> {

    private class ContributionHandler extends DefaultHandler {
        private Contribution currentContribution;
        private String thisElement;
        private List<Contribution> contributions = new LinkedList<>();

        private List<Contribution> getParsed() {
            return contributions;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            thisElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            thisElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            switch (thisElement) {
                case "name":
                    currentContribution = new Contribution();
                    currentContribution.setName(new String(ch, start, length));
                    break;
                case "country":
                    currentContribution.setCountry(new String(ch, start, length));
                    break;
                case "type":
                    currentContribution.setType(new String(ch, start, length));
                    break;
                case "depositor":
                    currentContribution.setDepositor(new String(ch, start, length));
                    break;
                case "account_id":
                    currentContribution.setAccountId(Integer.parseInt(new String(ch, start, length)));
                    break;
                case "amount_on_deposit":
                    currentContribution.setAmountOfDeposit(Double.parseDouble(new String(ch, start, length)));
                    break;
                case "profitability":
                    currentContribution.setProfitability(Double.parseDouble(new String(ch, start, length)));
                    break;
                case "time_constraints":
                    currentContribution.setTimeConstraints(Double.parseDouble(new String(ch, start, length)));
                    contributions.add(currentContribution);
                    break;
            }
        }
    }

    @Override
    public List<Contribution> parse(File parsedFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ContributionHandler contributionHandler = new ContributionHandler();
            parser.parse(parsedFile, contributionHandler);
            return contributionHandler.getParsed();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
