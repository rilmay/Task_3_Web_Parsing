package com.epam.webParsing.service.parser.parser_xml.parser_contribution;

import com.epam.webParsing.entity.Contribution;
import com.epam.webParsing.service.parser.parser_interface.XmlParser;

import java.io.File;
import java.util.List;

public class ContributionSaxParser implements XmlParser<Contribution> {
    @Override
    public List<Contribution> parse(File parsedFile) {
        return null;
    }
}
