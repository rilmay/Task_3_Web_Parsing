package com.epam.parsing.service.reader;

import com.epam.parsing.exception.IncorrectInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class FileReaderTest {
    private FileReader fileReader;
    private String filePath;
    private String incorrectPath;

    @BeforeTest
    public void init() {
        fileReader = FileReader.getInstance();
        filePath = "src/test/resources/gems/Gems1.xml";
        incorrectPath = "src/blabla";
    }

    @Test
    public void testRead() {
        Assert.assertEquals(new File(filePath).getName(), fileReader.read(filePath).getName());
    }

    @Test(expectedExceptions = IncorrectInputException.class)
    public void testReadFailed() {
        Assert.assertEquals(new File(filePath), fileReader.read(incorrectPath));
    }
}
