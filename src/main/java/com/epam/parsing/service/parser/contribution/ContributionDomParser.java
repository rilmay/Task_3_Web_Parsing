package com.epam.parsing.service.parser.contribution;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContributionDomParser implements XmlParser<Contribution> {
    private static Logger logger = LogManager.getLogger(ContributionDomParser.class);

    @Override
    public List<Contribution> parse(File parsedFile) {
        List<Contribution> contributions = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(parsedFile);

            NodeList contributionElements = document.getElementsByTagName("contribution");
            for (int i = 0; i < contributionElements.getLength(); i++) {
                Node contribution = contributionElements.item(i);
                NodeList elements = contribution.getChildNodes();
                Contribution parsed = new Contribution();

                parsed.setName(getText(elements, 1));
                parsed.setCountry(getText(elements, 2));
                parsed.setType(getText(elements, 3));
                parsed.setDepositor(getText(elements, 4));
                parsed.setAccountId(Integer.parseInt(getText(elements, 5)));
                parsed.setAmountOfDeposit(Double.parseDouble(getText(elements, 6)));
                parsed.setProfitability(Double.parseDouble(getText(elements, 7)));
                parsed.setTimeConstraints(Double.parseDouble(getText(elements, 8)));

                contributions.add(parsed);
            }
        } catch (ParserConfigurationException | SAXException | IOException | IllegalArgumentException e) {
            logger.error("Exception occurs while parsing: " + e.getMessage());
            throw new IncorrectInputException(e);
        }
        return contributions;
    }

    private String getText(NodeList nodeList, Integer currentPosition) {
        for (int j = 0; j < nodeList.getLength(); j++) {
            if (nodeList.item(j).getNodeType() != Node.TEXT_NODE) {
                currentPosition--;
                if (currentPosition == 0) {
                    return nodeList.item(j).getTextContent();
                }
            }
        }
        logger.error("Invalid file");
        throw new IllegalArgumentException("Invalid file");
    }
}