package com.epam.parsing.service.writer.impl;

import com.epam.parsing.entity.Gemstone;
import com.epam.parsing.service.writer.XMLWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GemstoneWriter implements XMLWriter<Gemstone> {
    private static Logger logger = LogManager.getLogger(GemstoneWriter.class);
    private static final GemstoneWriter instance = new GemstoneWriter();

    public static GemstoneWriter getInstance() {
        return instance;
    }

    public boolean write(List<Gemstone> gemstones, String path) {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(path));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Gems");
            for (Gemstone current : gemstones) {
                if (current == null) {
                    break;
                }
                writer.writeStartElement("Gem");

                writer.writeStartElement("Name");
                writer.writeCharacters(current.getName());
                writer.writeEndElement();

                writer.writeStartElement("Preciousness");
                writer.writeCharacters(current.getName());
                writer.writeEndElement();

                writer.writeStartElement("Origin");
                writer.writeCharacters(current.getName());
                writer.writeEndElement();

                writer.writeStartElement("VisualParameters");

                if (!current.getColor().isEmpty()) {
                    writer.writeStartElement("Color");
                    writer.writeCharacters(current.getName());
                    writer.writeEndElement();
                }

                writer.writeStartElement("Transparency");
                writer.writeCharacters(Double.toString(current.getTransparency()));
                writer.writeEndElement();

                writer.writeStartElement("CuttingMethod");
                writer.writeCharacters(Double.toString(current.getCuttingMethod()));
                writer.writeEndElement();

                writer.writeStartElement("Value");
                writer.writeCharacters(Double.toString(current.getValue()));
                writer.writeEndElement();

                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            return true;
        } catch (IOException | XMLStreamException e) {
            logger.error("Exception occurs while writing " + e.getMessage());
            return false;
        }
    }
}
