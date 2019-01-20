package com.epam.parsing.service.parser.contribution;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ContributionStaxParser implements XmlParser<Contribution> {
    private static Logger logger = LogManager.getLogger(ContributionStaxParser.class);


    @Override
    public List<Contribution> parse(File parsedFile) {
        List<Contribution> contributions = new ArrayList<>();
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
            logger.error("Exception occurs while parsing:" + e.getMessage());
            throw new IncorrectInputException("Exception occurs while parsing: " + e.getMessage());
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
                logger.error("Invalid file");
                throw new IncorrectInputException("Invalid file");
        }
    }
}
