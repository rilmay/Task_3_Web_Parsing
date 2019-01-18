package com.epam.webParsing.service.parser.xml.gemstone;

import com.epam.webParsing.entity.Gemstone;
import com.epam.webParsing.service.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GemstoneStaxParser implements XmlParser<Gemstone> {

    private static Logger logger = LogManager.getLogger(GemstoneStaxParser.class);
    private StartElement startElement;
    private Gemstone gemstone;
    private XMLEvent xmlEvent;
    private XMLEventReader xmlEventReader;

    @Override
    public List<Gemstone> parse(File parsedFile) {
        List<Gemstone> gemstoneList = new ArrayList<>();
        gemstone = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(parsedFile));
            while (xmlEventReader.hasNext()) {
                xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    startElement = xmlEvent.asStartElement();
                    getGemAttributes();

                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Gem")) {
                        gemstoneList.add(gemstone);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            logger.error(e.getMessage());

        }
        return gemstoneList;
    }

    private void getGemAttributes() {
        try {
            switch (startElement.getName().getLocalPart()) {
                case "Gem":
                    gemstone = new Gemstone();
                    break;
                case "Name":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setName(xmlEvent.asCharacters().getData());
                    }
                    break;
                case "Preciousness":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setPreciousness(xmlEvent.asCharacters().getData());
                    }
                    break;
                case "Origin":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setOrigin(xmlEvent.asCharacters().getData());
                    }
                    break;
                case "Transparency":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setTransparency(Double.valueOf(xmlEvent.asCharacters().getData()));
                    }
                    break;
                case "Color":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setColor(xmlEvent.asCharacters().getData());
                    }
                    break;
                case "CuttingMethod":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setCuttingMethod(Integer.valueOf(xmlEvent.asCharacters().getData()));
                    }
                    break;
                case "Value":
                    xmlEvent = xmlEventReader.nextEvent();
                    if (gemstone != null) {
                        gemstone.setValue(Double.valueOf(xmlEvent.asCharacters().getData()));
                    }
                    break;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
