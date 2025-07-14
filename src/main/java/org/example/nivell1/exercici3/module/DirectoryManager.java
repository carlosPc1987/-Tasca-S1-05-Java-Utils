package org.example.nivell1.exercici3.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici3.interfaces.AdvancedSortStrategy;
import org.example.nivell1.exercici3.interfaces.LinePrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryManager {
    private final AdvancedSortStrategy sortStrategy;

    public DirectoryManager(AdvancedSortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void listDirectoryTreeToConsole(String path) throws InvalidDirectoryException {
        File root = new File(path);
        if (!root.exists() || !root.isDirectory()) {
            throw new InvalidDirectoryException("El directori no existeix o no és vàlid.");
        }

        LinePrinter printer = new ConsolePrinter();
        printer.print(" Contingut de l’arbre de directoris:\n");
        listRecursively(root, 0, printer);
    }

    public void listDirectoryTreeToFile(String path, String outputFile) throws InvalidDirectoryException {
        File root = new File(path);
        if (!root.exists() || !root.isDirectory()) {
            throw new InvalidDirectoryException("El directori no existeix o no és vàlid.");
        }

        try (PrintWriter writer = new PrintWriter(outputFile)) {
            LinePrinter printer = new FilePrinter(writer);
            printer.print(" Contingut de l’arbre de directoris:\n");
            listRecursively(root, 0, printer);
        } catch (FileNotFoundException e) {
            throw new InvalidDirectoryException("No s'ha pogut escriure al fitxer de sortida.");
        }
    }

    private void listRecursively(File directory, int level, LinePrinter printer) {
        File[] elements = directory.listFiles();
        if (elements == null || elements.length == 0) return;

        File[] sorted = sortStrategy.sort(elements);
        String indent = "  ".repeat(level);

        for (File file : sorted) {
            String type = file.isDirectory() ? "(D)" : "(F)";
            String date = formatDate(file.lastModified());
            printer.print(indent + "• " + file.getName() + " " + type + " - modificat el " + date);

            if (file.isDirectory()) {
                listRecursively(file, level + 1, printer);
            }
        }
    }

    private String formatDate(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(new Date(millis));
    }
}