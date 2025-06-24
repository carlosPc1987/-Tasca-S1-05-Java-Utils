package nivell1.exercici1.module;

import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortStrategyTest {

    @Test
    void testSortingAlphabetically() {
        SortStrategy sorter = new SelectionSortStrategy();
        List<String> files = List.of("banana.txt", "apple.txt", "cherry.txt");

        List<String> sortedFiles = sorter.sort(files);
        assertEquals(List.of("apple.txt", "banana.txt", "cherry.txt"), sortedFiles);
    }

    @Test
    void testSortingWithEmptyList() {
        SortStrategy sorter = new SelectionSortStrategy();
        List<String> files = List.of();

        List<String> sortedFiles = sorter.sort(files);
        assertTrue(sortedFiles.isEmpty());
    }
}
