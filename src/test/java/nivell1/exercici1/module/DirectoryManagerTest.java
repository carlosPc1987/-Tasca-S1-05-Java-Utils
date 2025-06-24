package nivell1.exercici1.module;


import org.example.nivell1.exercici1.interfaces.SortStrategy;
import org.example.nivell1.exercici1.module.DirectoryManager;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

public class DirectoryManagerTest {

    @Test
    void testValidDirectoryListing() throws Exception {
        SortStrategy sorter = new SelectionSortStrategy();
        DirectoryManager manager = new DirectoryManager(sorter);

        String path = new File("testDirectory").getAbsolutePath();
        new File(path).mkdir();

        List<String> files = List.of("file1.txt", "file2.txt", "file3.txt");
        for (String file : files) {
            new File(path + File.separator + file).createNewFile();
        }

        assertDoesNotThrow(() -> manager.listSortedDirectory(path));
    }

    @Test
    void testInvalidDirectoryThrowsException() {
        SortStrategy sorter = new SelectionSortStrategy();
        DirectoryManager manager = new DirectoryManager(sorter);

        String invalidPath = "nonExistentDirectory";
        assertThrows(Exception.class, () -> manager.listSortedDirectory(invalidPath));
    }
}
