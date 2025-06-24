package org.example.nivell1.exercici5.module;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DirectoryManager {


    public DirectoryInfo getDirectoryInfo(String path) {
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("El directori no existeix o no és vàlid.");
        }

        File[] files = directory.listFiles();
        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            fileNames = Arrays.stream(files)
                    .map(File::getName)
                    .sorted(String::compareToIgnoreCase)
                    .toList();
        }
        return new DirectoryInfo(path, fileNames);
    }

    public void serializeDirectory(DirectoryInfo info, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(info);
            System.out.println("Directori serialitzat i guardat a: " + filePath);
        } catch (IOException e) {
            System.out.println("Error en la serialització: " + e.getMessage());
        }
    }

    public DirectoryInfo deserializeDirectory(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (DirectoryInfo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la desserialització: " + e.getMessage());
            return null;
        }
    }

    public void listDirectoryTree() {

        String directoryPath = config.getProperty("directory.path");
        String outputFile = config.getProperty("output.file");

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Error: El directori no existeix o no és vàlid.");
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            listTreeRecursively(directory, 0, writer);
            System.out.println("Resultat guardat a: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error al guardar el fitxer: " + e.getMessage());
        }
    }

    private void listTreeRecursively(File directory, int i, FileWriter writer) {
    }

    private ConfigManager config;

    public DirectoryManager() {
        if (config == null) {
            this.config = config;
        }
    }
}