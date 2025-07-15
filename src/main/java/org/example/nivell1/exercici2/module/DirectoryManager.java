package org.example.nivell1.exercici2.module;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;

import org.example.nivell1.exercici1.module.DirectoryExistsRule;
import org.example.nivell1.exercici1.module.DirectoryValidator;
import org.example.nivell1.exercici1.module.DirectoryRule;
import org.example.nivell1.exercici1.module.DirectoryContentRule;

public class DirectoryManager {
    private final SortStrategy sorter;
    private final DirectoryValidator validator;

    public DirectoryManager(SortStrategy sorter) {
        this.sorter = sorter;
        this.validator = new DirectoryValidator(
                List.of(new DirectoryExistsRule(), new DirectoryRule(), new DirectoryContentRule())
        );
    }

    public void listDirectoryTree(String path) throws InvalidDirectoryException {
        validator.validate(path);
        listTreeRecursively(new File(path), 0);
    }

    private void listTreeRecursively(File directory, int depth) {
        File[] files = directory.listFiles();
        if (files != null) {

            List<File> sortedFiles = sorter.sort(Arrays.stream(files)
                            .map(File::getName).toList()).stream()
                    .map(name -> new File(directory, name)).toList();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            for (File file : sortedFiles) {
                String indentation = "   ".repeat(depth);
                String lastModified = dateFormat.format(file.lastModified());
                String type = file.isDirectory() ? "[D]" : "[F]";

                System.out.println(indentation + type + " " + file.getName() + " __ " + lastModified);

                if (file.isDirectory()) {
                    listTreeRecursively(file, depth + 1);
                }
            }
        }
    }
}