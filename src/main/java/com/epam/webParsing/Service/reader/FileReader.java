package com.epam.webParsing.Service.reader;

import java.io.File;

public class FileReader {
    private static FileReader instance = new FileReader();

    public static FileReader getInstance() {
        return instance;
    }

    public File read(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException();
        }
        return file;
    }
}
