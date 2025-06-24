package org.example.nivell1.exercici3.application;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;
import org.example.nivell1.exercici3.module.DirectoryManager;

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

    public void executeProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el directori: ");
        String path = scanner.nextLine();
        System.out.print("Introdueix el nom del fitxer de sortida: ");
        String outputFile = scanner.nextLine();
        scanner.close();

        run(path, outputFile);
    }
}