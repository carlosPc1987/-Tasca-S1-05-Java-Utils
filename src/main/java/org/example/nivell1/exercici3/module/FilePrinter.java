package org.example.nivell1.exercici3.module;

import org.example.nivell1.exercici3.interfaces.LinePrinter;

import java.io.PrintWriter;

public class FilePrinter implements LinePrinter {
    private final PrintWriter writer;

    public FilePrinter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void print(String line) {
        writer.println(line);
    }
}