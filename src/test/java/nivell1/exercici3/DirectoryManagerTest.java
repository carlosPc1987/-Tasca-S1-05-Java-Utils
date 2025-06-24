package nivell1.exercici3;


import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;
import org.example.nivell1.exercici3.module.DirectoryManager;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryManagerTest {

    @Test
    void testDirectoryTreeOutputToFile() throws IOException, InvalidDirectoryException {

        File testDir = new File("testDirectory");
        testDir.mkdir();

        File outputFile = new File("output_test.txt");

        DirectoryManager manager = new DirectoryManager(new SelectionSortStrategy());
        manager.listDirectoryTree("testDirectory", "output_test.txt");

        String fileContent = Files.readString(Path.of(outputFile.getPath())).trim();

        assertFalse(fileContent.isEmpty());
        assertTrue(fileContent.contains("[D]") || fileContent.contains("[F]"));

        Files.deleteIfExists(Path.of(outputFile.getPath()));
        testDir.delete();
    }
}

