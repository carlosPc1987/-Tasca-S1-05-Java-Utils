package org.example.nivell1.exercici5.application;

import org.example.nivell1.exercici5.module.DirectoryInfo;
import org.example.nivell1.exercici5.module.DirectoryManager;
import org.example.nivell1.exercici5.module.ConfigManager;

import java.util.Scanner;

public class MainApp {
    public void executeProgram() {
        Scanner scanner = new Scanner(System.in);
        ConfigManager config = new ConfigManager("src/main/resources/config.properties");
        DirectoryManager manager = new DirectoryManager();

        System.out.print("Acció (listar | serialitzar | desserialitzar): ");
        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("desserialitzar")) {
            DirectoryInfo deserializedInfo = manager.deserializeDirectory("directori.ser");
            if (deserializedInfo != null) {
                System.out.println("Objecte desserialitzat:\n" + deserializedInfo);
            }
        } else {
            System.out.print("Introdueix la ruta del directori: ");
            String path = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "listar" -> {
                    DirectoryInfo info = manager.getDirectoryInfo(path);
                    System.out.println(info);
                }
                case "serialitzar" -> {
                    DirectoryInfo infoToSerialize = manager.getDirectoryInfo(path);
                    manager.serializeDirectory(infoToSerialize, "directori.ser");
                }
                default -> System.out.println("Opció desconeguda. Ús: listar | serialitzar | desserialitzar");
            }
        }

        scanner.close();
    }
}