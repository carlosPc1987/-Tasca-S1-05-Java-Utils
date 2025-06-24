package nivell1.exercici2;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici2.module.DirectoryManager;
import org.example.nivell1.exercici1.module.SelectionSortStrategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;


public class DirectoryManagerTest {

    @Test
    void testRecursiveDirectoryListing() throws InvalidDirectoryException {

        File testDir = new File("testDirectory");
        testDir.mkdir();


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DirectoryManager manager = new DirectoryManager(new SelectionSortStrategy());
        manager.listDirectoryTree("testDirectory");

        String output = outputStream.toString().trim();
        assertTrue(output.contains("[D]") || output.contains("[F]"));

        testDir.delete();
    }
}