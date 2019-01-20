package com.epam.parsing.service.writer.impl;

import com.epam.parsing.entity.Contribution;
import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.parser.contribution.utility.ParserUtility;
import com.epam.parsing.service.writer.XMLWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContributionWriter implements XMLWriter<Contribution> {
    private static Logger logger = LogManager.getLogger(ContributionWriter.class);
    private static final ContributionWriter instance = new ContributionWriter();

    public static ContributionWriter getInstance() {
        return instance;
    }

    public boolean write(List<Contribution> contributions, String path) {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(path));
            writer.writeStartDocument("UTF-8","1.0");
            writer.writeStartElement("banks");
            for (Contribution current : contributions) {
                if (current == null) {
                    break;
                }
                writer.writeStartElement("contribution");
                writer.writeStartElement("name");
                writer.writeCharacters(current.getName());
                writer.writeEndElement();

                writer.writeStartElement("country");
                writer.writeCharacters(current.getCountry());
                writer.writeEndElement();
                writer.writeStartElement("type");
                writer.writeCharacters(current.getType());
                writer.writeEndElement();
                writer.writeStartElement("depositor");
                writer.writeCharacters(current.getDepositor());
                writer.writeEndElement();
                writer.writeStartElement("account_id");
                writer.writeCharacters(Integer.toString(current.getAccountId()));
                writer.writeEndElement();
                writer.writeStartElement("amount_on_deposit");
                writer.writeCharacters(Double.toString(current.getAmountOfDeposit()));
                writer.writeEndElement();
                writer.writeStartElement("profitability");
                writer.writeCharacters(Double.toString(current.getProfitability()));
                writer.writeEndElement();
                writer.writeStartElement("time_constraints");
                writer.writeCharacters(ParserUtility.reverseDateFormat(current.getTimeConstraints()));
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            return true;
        } catch (IOException | XMLStreamException e) {
            logger.error("Exception occurs while writing "+e.getMessage());
            return false;
        }

    }
}
