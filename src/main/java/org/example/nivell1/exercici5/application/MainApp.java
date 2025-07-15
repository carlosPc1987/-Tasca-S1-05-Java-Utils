package org.example.nivell1.exercici5.application;

import org.example.nivell1.exercici5.module.DirectoryInfo;
import org.example.nivell1.exercici5.module.DirectoryManager;

import java.io.File;
import java.util.Scanner;

public class MainApp {
    public void executeProgram() {
        Scanner scanner = new Scanner(System.in);
        String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
        DirectoryManager manager = new DirectoryManager(path);

        System.out.print("Action (list | serialize | deserialize): ");
        String action = scanner.nextLine().trim();

        try {
            if (action.equalsIgnoreCase("deserialize")) {
                DirectoryInfo deserializedInfo = manager.deserializeDirectory("directory.ser");
                if (deserializedInfo != null) {
                    System.out.println("Object deserialization:\n" + deserializedInfo);
                }
            } else {
                System.out.print("Introdueix la ruta del directory: ");
                String directoryPath = scanner.nextLine().trim();
                DirectoryInfo info = manager.getDirectoryInfo(directoryPath);


                switch (action.toLowerCase()) {
                    case "list" -> System.out.println(info);
                    case "serialize" -> {
                        manager.serializeDirectory(info, "directory.ser");
                        System.out.println("Directori serialitzat correctament.");
                    }
                    default -> System.out.println("Opció desconeguda. Ús: list | serialize | deserializer");
                }
            }
        } catch (Exception e) {
            System.err.println(" Error durant l'execució: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}