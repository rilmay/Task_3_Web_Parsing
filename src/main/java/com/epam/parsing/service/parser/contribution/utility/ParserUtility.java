package com.epam.parsing.service.parser.contribution.utility;

public class ParserUtility {
    public static String getFormattedDate(String input){
        return input.replaceAll("[PT]","").replaceAll("Y"," years ")
                .replaceAll("M"," months ").replaceAll("D"," days ")
                .replaceAll("H"," hours ").trim();
    }
}
