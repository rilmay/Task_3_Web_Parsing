package com.epam.webParsing.Service.parser.xmlParser.gemstoneParser;

import com.epam.webParsing.Service.parser.ParserInterface.XmlParser;
import com.epam.webParsing.entity.Gemstone;

import java.io.File;
import java.util.List;

public class GemstoneStaxParser implements XmlParser<Gemstone> {
    @Override
    public List<Gemstone> parse(File parsedFile) {
        return null;
    }
}
