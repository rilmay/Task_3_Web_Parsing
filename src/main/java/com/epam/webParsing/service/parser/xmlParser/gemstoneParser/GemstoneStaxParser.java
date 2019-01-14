package com.epam.webParsing.service.parser.xmlParser.gemstoneParser;

import com.epam.webParsing.service.parser.parserInterface.XmlParser;
import com.epam.webParsing.entity.Gemstone;

import java.io.File;
import java.util.List;

public class GemstoneStaxParser implements XmlParser<Gemstone> {
    @Override
    public List<Gemstone> parse(File parsedFile) {
        return null;
    }
}
