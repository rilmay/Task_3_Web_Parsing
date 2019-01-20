package com.epam.parsing.service.parser.contribution.utility;

public class ParserUtility {
    public static String getFormattedDate(String input) {
        return input.replaceAll("[PT]", "").replaceAll("Y", " years ")
                .replaceAll("M", " months ").replaceAll("D", " days ")
                .replaceAll("H", " hours ").trim();
    }

    public static String reverseDateFormat(String input) {
        return "P" + input.replaceAll("years", "Y").replaceAll("months", "M")
                .replaceAll("days", "D").replaceAll("([0-9]+)( hours)", "T$1H")
                .replaceAll(" ", "");
    }
}
