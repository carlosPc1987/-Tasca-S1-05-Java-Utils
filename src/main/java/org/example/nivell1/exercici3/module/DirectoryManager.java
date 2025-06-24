package org.example.nivell1.exercici3.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.DirectoryExistsRule;
import org.example.nivell1.exercici1.module.DirectoryValidator;
import org.example.nivell1.exercici1.module.IsDirectoryRule;
import org.example.nivell1.exercici1.module.IsNotEmptyRule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        validator.validate(path); // Validar el directori
        try (FileWriter writer = new FileWriter(outputFile)) {
            listTreeRecursively(new File(path), 0, writer); // Escriure al fitxer
        } catch (IOException e) {
            System.out.println("Error al guardar el fitxer: " + e.getMessage());
        }
    }

    private void listTreeRecursively(File directory, int depth, FileWriter writer) throws IOException {
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

                writer.write(indentation + type + " " + file.getName() + " __ " + lastModified + "\n");

                if (file.isDirectory()) {
                    listTreeRecursively(file, depth + 1, writer);
                }
            }
        }
    }
}