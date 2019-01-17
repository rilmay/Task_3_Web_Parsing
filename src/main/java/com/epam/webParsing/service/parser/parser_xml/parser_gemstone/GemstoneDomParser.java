package com.epam.webParsing.service.parser.parser_xml.parser_gemstone;

import com.epam.webParsing.entity.Gemstone;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;
import org.apache.log4j.Logger;
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

public class GemstoneDomParser implements XmlParser<Gemstone> {

    private static Logger logger = Logger.getLogger(GemstoneDomParser.class.getName());

    @Override
    public List<Gemstone> parse(File parsedFile) {
        List<Gemstone> gemstoneList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(parsedFile);
            gemstoneList = parseParameters(document.getDocumentElement().getElementsByTagName("Gem"));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error(e.getMessage());
        }
        return gemstoneList;
    }

    private List<Gemstone> parseParameters(NodeList gemStoneElements) {
        List<Gemstone> gemstoneList = new ArrayList<>();
        for (int i = 0; i < gemStoneElements.getLength(); i++) {
            Node gem = gemStoneElements.item(i);
            Gemstone gemstone = new Gemstone();
            if (gem.getNodeType() != Node.TEXT_NODE) {
                for (int j = 0; j < gem.getChildNodes().getLength(); j++) {

                    switch (gem.getChildNodes().item(j).getNodeName()) {
                        case "Name":
                            gemstone.setName(gem.getChildNodes().item(j).getTextContent());
                            break;
                        case "Preciousness":
                            gemstone.setPreciousness(gem.getChildNodes().item(j).getTextContent());
                            break;
                        case "Origin":
                            gemstone.setOrigin(gem.getChildNodes().item(j).getTextContent());
                            break;
                        case "Value":
                            gemstone.setValue(Double.valueOf(gem.getChildNodes().item(j).getTextContent()));
                            break;
                        case "VisualParameters":
                            parseVisualParameters(gem.getChildNodes().item(j).getChildNodes(), gemstone);
                            break;
                    }

                }
                gemstoneList.add(gemstone);
            }

        }
        return gemstoneList;

    }

    private void parseVisualParameters(NodeList visualParameters, Gemstone gemstone) {

        for (int d = 0; d < visualParameters.getLength(); d++) {
            Node visualParameter = visualParameters.item(d);
            if (visualParameter.getNodeType() != Node.TEXT_NODE) {
                switch (visualParameter.getNodeName()) {
                    case "Color":
                        gemstone.setColor(visualParameter.getTextContent());
                        break;
                    case "Transparency":
                        gemstone.setTransparency(Double.valueOf(visualParameter.getTextContent()));
                        break;
                    case "CuttingMethod":
                        gemstone.setCuttingMethod(Integer.valueOf(visualParameter.getTextContent()));
                        break;
                }
            }
        }

    }
}
