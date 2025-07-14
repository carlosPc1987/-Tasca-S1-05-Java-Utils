package org.example.nivell1.exercici3.module;


import org.example.nivell1.exercici3.interfaces.AdvancedSortStrategy;

import java.io.File;

public class SelectionFileSortStrategy implements AdvancedSortStrategy {
    @Override
    public File[] sort(File[] files) {
        File[] sorted = files.clone();
        for (int i = 0; i < sorted.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (sorted[j].getName().compareToIgnoreCase(sorted[min].getName()) < 0) {
                    min = j;
                }
            }
            File temp = sorted[i];
            sorted[i] = sorted[min];
            sorted[min] = temp;
        }
        return sorted;
    }
}
