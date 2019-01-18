package com.epam.webParsing.service.reader;

import com.epam.webParsing.exception.IncorrectInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileReader {
    private static Logger logger = LogManager.getLogger(FileReader.class);
    private static FileReader instance = new FileReader();

    public static FileReader getInstance() {
        return instance;
    }

    public File read(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            logger.error("File does not exist or not a file");
            throw new IncorrectInputException("File does not exist or not a file");
        }
        return file;
    }
}
