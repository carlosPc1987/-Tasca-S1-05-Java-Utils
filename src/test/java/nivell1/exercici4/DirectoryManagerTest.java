package nivell1.exercici4;


import org.example.nivell1.exercici4.module.DirectoryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryManagerTest {

    @Test
    void testReadTextFile() throws IOException {
        File testFile = new File("test_read.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Hola, aquest és un fitxer de prova!\nSegona línia de text.");
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DirectoryManager manager = new DirectoryManager(null);
        manager.readTextFile("test_read.txt");

        String consoleOutput = outputStream.toString().trim();

        assertTrue(consoleOutput.contains("Hola, aquest és un fitxer de prova!"));
        assertTrue(consoleOutput.contains("Segona línia de text."));

        Files.deleteIfExists(Path.of(testFile.getPath()));
    }
}