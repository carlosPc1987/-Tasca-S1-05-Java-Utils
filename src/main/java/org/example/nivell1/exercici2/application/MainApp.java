package org.example.nivell1.exercici2.application;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.DirectoryManager;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;

import java.util.Scanner;

public class MainApp {
    public void run(String path) {
        SortStrategy sorter = new SelectionSortStrategy();
        DirectoryManager manager = new DirectoryManager(sorter);

        try {
            manager.listSortedDirectory(path);
        } catch (InvalidDirectoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void executeProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        run(path);
    }
}