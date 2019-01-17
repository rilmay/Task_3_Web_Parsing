package com.epam.webParsing.service.parser.parser_xml.parser_contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class ContributionStaxParser implements XmlParser<Contribution> {
    @Override
    public List<Contribution> parse(File parsedFile) {
        List<Contribution> contributions = new LinkedList<>();
        Contribution currentContribution = new Contribution();
        try {
            XMLStreamReader xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(parsedFile));
            String current = "";
            while (xmlReader.hasNext()) {
                xmlReader.next();
                if (xmlReader.isStartElement()) {
                    current = xmlReader.getLocalName();
                } else if (xmlReader.hasText() && xmlReader.getText().trim().length() > 0) {
                    fillTheFields(xmlReader.getText(), currentContribution, current);
                    if (current.equals("time_constraints")) {
                        contributions.add(currentContribution);
                        currentContribution = new Contribution();
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new IllegalArgumentException(e);
        }
        return contributions;
    }

    private void fillTheFields(String text, Contribution input, String currentField) {
        switch (currentField) {
            case "name":
                input.setName(text);
                break;
            case "country":
                input.setCountry(text);
                break;
            case "type":
                input.setType(text);
                break;
            case "depositor":
                input.setDepositor(text);
                break;
            case "account_id":
                input.setAccountId(Integer.parseInt(text));
                break;
            case "amount_on_deposit":
                input.setAmountOfDeposit(Double.parseDouble(text));
                break;
            case "profitability":
                input.setProfitability(Double.parseDouble(text));
                break;
            case "time_constraints":
                input.setTimeConstraints(Double.parseDouble(text));
                break;
            default:
                throw new IllegalArgumentException("Incorrect input");
        }
    }
}
