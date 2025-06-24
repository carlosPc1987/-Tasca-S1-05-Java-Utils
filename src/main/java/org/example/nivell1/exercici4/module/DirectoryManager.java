package org.example.nivell1.exercici4.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.DirectoryExistsRule;
import org.example.nivell1.exercici1.module.DirectoryValidator;
import org.example.nivell1.exercici1.module.IsDirectoryRule;
import org.example.nivell1.exercici1.module.IsNotEmptyRule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class DirectoryManager {
    private final SortStrategy sorter;
    private final DirectoryValidator validator;

    public DirectoryManager(SortStrategy sorter) {
        this.sorter = sorter;
        this.validator = new DirectoryValidator(
                List.of(new DirectoryExistsRule(), new IsDirectoryRule(), new IsNotEmptyRule())
        );
    }

    public void listDirectoryTree(String path, String outputFile) throws InvalidDirectoryException {
        validator.validate(path);
        try (FileWriter writer = new FileWriter(outputFile)) {
            listTreeRecursively(new File(path), 0, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el fitxer: " + e.getMessage());
        }
    }

    private void listTreeRecursively(File directory, int depth, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            List<File> sortedFiles = Arrays.stream(files)
                    .sorted((f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()))
                    .toList();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            for (File file : sortedFiles) {
                String indentation = "   ".repeat(depth);
                String type = file.isDirectory() ? "[D]" : "[F]";
                String lastModified = dateFormat.format(file.lastModified());

                writer.write(indentation + type + " " + file.getName() + " __ " + lastModified + "\n");

                if (file.isDirectory()) {
                    listTreeRecursively(file, depth + 1, writer);
                }
            }
        }
    }

    public void readTextFile(String filePath) {
        try {
            String content = Files.readString(Path.of(filePath));
            System.out.println("Contingut del fitxer:\n" + content);
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer: " + e.getMessage());
        }
    }
}
