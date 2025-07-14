package org.example.nivell1.exercici1.module;

import org.example.nivell1.exercici1.interfaces.SortStrategy;

import java.util.List;
import java.util.ArrayList;

public class SelectionSortStrategy implements SortStrategy {
    @Override
    public List<String> sort(List<String> files) {
        List<String> sortedList = new ArrayList<>(files);

        for (int i = 0; i < sortedList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(j).compareTo(sortedList.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = sortedList.get(i);
            sortedList.set(i, sortedList.get(minIndex));
            sortedList.set(minIndex, temp);
        }
        return sortedList;
    }
}
