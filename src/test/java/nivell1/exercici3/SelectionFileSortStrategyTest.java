package nivell1.exercici3;

import org.junit.jupiter.api.Test;

import java.io.File;

import org.example.nivell1.exercici3.interfaces.AdvancedSortStrategy;
import org.example.nivell1.exercici3.module.SelectionFileSortStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionFileSortStrategyTest {

    @Test
    public void givenUnorderedFiles_whenSorted_thenReturnsAlphabeticalOrder() {
        AdvancedSortStrategy sorter = new SelectionFileSortStrategy();

        File[] input = {
                new File("zebra.txt"),
                new File("Apple.txt"),
                new File("music.mp3"),
                new File("document.pdf")
        };

        File[] result = sorter.sort(input);

        assertEquals("Apple.txt", result[0].getName());
        assertEquals("document.pdf", result[1].getName());
        assertEquals("music.mp3", result[2].getName());
        assertEquals("zebra.txt", result[3].getName());
    }

    @Test
    public void givenEmptyArray_whenSorted_thenReturnsEmptyArray() {
        AdvancedSortStrategy sorter = new SelectionFileSortStrategy();
        File[] input = {};
        File[] result = sorter.sort(input);
        assertEquals(0, result.length);
    }

    @Test
    public void givenFilesWithSameName_whenSorted_thenPreservesOrder() {
        AdvancedSortStrategy sorter = new SelectionFileSortStrategy();

        File[] input = {
                new File("test.txt"),
                new File("test.txt")
        };

        File[] result = sorter.sort(input);

        assertEquals("test.txt", result[0].getName());
        assertEquals("test.txt", result[1].getName());
    }
}