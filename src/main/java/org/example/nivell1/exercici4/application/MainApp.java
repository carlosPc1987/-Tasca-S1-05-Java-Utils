package org.example.nivell1.exercici4.application;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;
import org.example.nivell1.exercici4.module.DirectoryManager;

import java.util.Scanner;

public class MainApp {
    public void run(String path, String outputFile) {
        SortStrategy sorter = new SelectionSortStrategy();
        DirectoryManager manager = new DirectoryManager(sorter);

        try {
            manager.listDirectoryTree(path, outputFile);
            System.out.println("Resultat guardat a: " + outputFile);
        } catch (InvalidDirectoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readFile(String filePath) {
        DirectoryManager manager = new DirectoryManager(new SelectionSortStrategy());
        manager.readTextFile(filePath);
    }

    public void executeProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix una acció (run o read): ");
        String action = scanner.nextLine();

        if (action.equalsIgnoreCase("read")) {
            System.out.print("Fitxer a llegir: ");
            String filePath = scanner.nextLine();
            readFile(filePath);
        } else if (action.equalsIgnoreCase("run")) {
            System.out.print("Directori d’entrada: ");
            String path = scanner.nextLine();
            System.out.print("Nom del fitxer de sortida: ");
            String outputFile = scanner.nextLine();
            run(path, outputFile);
        } else {
            System.out.println("Acció no reconeguda.");
        }

        scanner.close();
    }
}