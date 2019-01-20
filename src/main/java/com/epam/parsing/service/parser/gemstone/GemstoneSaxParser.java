package com.epam.parsing.service.parser.gemstone;

import com.epam.parsing.entity.Gemstone;
import com.epam.parsing.exception.IncorrectInputException;
import com.epam.parsing.service.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GemstoneSaxParser implements XmlParser<Gemstone> {
    private static Logger logger = LogManager.getLogger(GemstoneSaxParser.class);

    @Override
    public List<Gemstone> parse(File parsedFile) {
        List<Gemstone> gemstoneList = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                String lastElementName;
                String name;
                String preciousness;
                String origin;
                String color;
                Double transparency;
                Integer cuttingMethod;
                Double value;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    lastElementName = qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String information = new String(ch, start, length);
                    information = information.replace("\n", "").trim();
                    if (!information.isEmpty()) {
                        switch (lastElementName) {
                            case "Name":
                                name = information;
                                break;
                            case "Preciousness":
                                preciousness = information;
                                break;
                            case "Origin":
                                origin = information;
                                break;
                            case "Color":
                                color = information;
                                break;
                            case "Value":
                                value = Double.valueOf(information);
                                break;
                            case "Transparency":
                                transparency = Double.valueOf(information);
                                break;
                            case "CuttingMethod":
                                cuttingMethod = Integer.valueOf(information);
                                break;
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    if ((name != null && !name.isEmpty()) && (preciousness != null && !preciousness.isEmpty())
                            && (origin != null && !origin.isEmpty()) && (color != null && !color.isEmpty())
                            && (transparency != null) && (cuttingMethod != null) && (value != null)) {
                        gemstoneList.add(new Gemstone(name, preciousness, origin, color, transparency, cuttingMethod, value));
                        name = null;
                        preciousness = null;
                        origin = null;
                        color = null;
                        transparency = null;
                        cuttingMethod = null;
                        value = null;
                    }

                }
            };

            saxParser.parse(parsedFile.getPath(), handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("Exception occurs while parsing:" + e.getMessage());
            throw new IncorrectInputException(e);
        }
        return gemstoneList;
    }

}
