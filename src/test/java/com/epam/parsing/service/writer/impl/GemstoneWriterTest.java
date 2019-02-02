package com.epam.parsing.service.writer.impl;

import com.epam.parsing.controller.MainController;
import com.epam.parsing.entity.Gemstone;
import com.epam.parsing.service.reader.FileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GemstoneWriterTest {
    private GemstoneWriter gemstoneWriter;
    private MainController mainController;
    private String gemstoneFilePath;
    private String resultPath;
    private FileReader fileReader;

    @BeforeTest
    public void init() {
        gemstoneWriter = GemstoneWriter.getInstance();
        mainController = MainController.getInstance();
        resultPath = "src/test/resources/temp/testGems.xml";
        gemstoneFilePath = "src/test/resources/gems/gems1.xml";
        fileReader = FileReader.getInstance();
    }


    @Test
    public void testWriterEquals() throws IOException {
        List<Gemstone> gemstones = mainController
                .readFileAndReturnParsed(gemstoneFilePath, "dom", Gemstone.class);
        gemstoneWriter.write(gemstones, resultPath);
        List<String> file1 = Files.readAllLines(Paths.get(gemstoneFilePath), StandardCharsets.UTF_8);
        String file1String = file1.stream().collect(Collectors.joining())
                .replaceAll("<.+?>", "").replaceAll("\\s", "");
        List<String> file2 = Files.readAllLines(Paths.get(resultPath), StandardCharsets.UTF_8);
        String file2String = file2.get(0).replaceAll("<.+?>", "")
                .replaceAll("\\.0", "").replaceAll("\\s", "");
        File f = new File(resultPath);
        f.delete();
        Assert.assertEquals(file1String, file2String);
    }
}
