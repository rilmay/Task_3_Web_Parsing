package com.epam.webParsing.service.parser.xmlParser.contributionParser;

import com.epam.webParsing.service.parser.parserInterface.XmlParser;
import com.epam.webParsing.entity.Contribution;

import java.io.File;
import java.util.List;

public class ContributionSaxParser implements XmlParser<Contribution> {
    @Override
    public List<Contribution> parse(File parsedFile) {
        return null;
    }
}
