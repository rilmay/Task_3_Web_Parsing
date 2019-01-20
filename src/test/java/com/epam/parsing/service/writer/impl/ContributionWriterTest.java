package com.epam.parsing.service.writer.impl;

import com.epam.parsing.controller.MainController;
import com.epam.parsing.entity.Contribution;
import com.epam.parsing.service.reader.FileReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContributionWriterTest {
    private ContributionWriter contributionWriter;
    private MainController mainController;
    private String contributionFilePath;
    private String resultPath;
    private FileReader fileReader;

    @BeforeTest
    public void init() {
        contributionWriter = ContributionWriter.getInstance();
        mainController = MainController.getInstance();
        resultPath = "src/test/resources/temp/testBanks.xml";
        contributionFilePath = "src/test/resources/banks/Banks1.xml";
        fileReader = FileReader.getInstance();
    }


    @Test
    public void testWriterEquals() throws IOException {
        List<Contribution> contributions = mainController
                .readFileAndReturnParsed(contributionFilePath, "dom", Contribution.class);
        contributionWriter.write(contributions, resultPath);
        List<String> file1 = Files.readAllLines(Paths.get(contributionFilePath), StandardCharsets.UTF_8);
        String file1String = file1.stream().collect(Collectors.joining());
        //file1String.replaceAll("<.+?>","").replaceAll("\\s","");
        System.out.println(file1String);

        List<String> file2 = Files.readAllLines(Paths.get(resultPath), StandardCharsets.UTF_8);
        String string2 = file2.get(0).replaceAll("<.+?>","").replaceAll("\\s","");
        System.out.println(string2);
        //List<String>filePered = file2.stream().flatMap(str -> Arrays.stream(str.split(">[ ]+<"))).collect(Collectors.toList());
        //filePered.forEach(System.out::println);


    }
}
