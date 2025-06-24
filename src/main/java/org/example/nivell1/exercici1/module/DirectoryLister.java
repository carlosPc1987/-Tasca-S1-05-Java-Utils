package org.example.nivell1.exercici1.module;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {
    private final File directory;

    public DirectoryLister(String directoryPath) {
        this.directory = new File(directoryPath);
    }

    public String[] getSortedFiles() {
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("El path proporcionat no és un directori vàlid.");
        }

        String[] files = directory.list();
        if (files != null) {
            Arrays.sort(files);
        }
        return files;
    }
}
