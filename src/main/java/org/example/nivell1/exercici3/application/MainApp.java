package org.example.nivell1.exercici3.application;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici3.interfaces.AdvancedSortStrategy;
import org.example.nivell1.exercici3.module.DirectoryManager;
import org.example.nivell1.exercici3.module.SelectionFileSortStrategy;

import java.util.Scanner;

public class MainApp {
    public void executeProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el directori: ");
        String path = scanner.nextLine();
        System.out.print("Introdueix el nom del fitxer de sortida: ");
        String outputFile = scanner.nextLine();
        scanner.close();

        AdvancedSortStrategy sorter = new SelectionFileSortStrategy();
        DirectoryManager manager = new DirectoryManager(sorter);

        try {
            manager.listDirectoryTreeToFile(path, outputFile);
            System.out.println(" Resultat guardat a: " + outputFile);
        } catch (InvalidDirectoryException e) {
            System.err.println(" Error: " + e.getMessage());
        }
    }
}