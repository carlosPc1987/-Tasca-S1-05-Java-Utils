package org.example.nivell1.exercici3.module;


import org.example.nivell1.exercici3.interfaces.LinePrinter;

public class ConsolePrinter implements LinePrinter {
    @Override
    public void print(String line) {
        System.out.println(line);
    }
}