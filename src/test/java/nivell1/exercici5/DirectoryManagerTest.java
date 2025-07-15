package nivell1.exercici5;


import org.example.nivell1.exercici5.module.DirectoryInfo;
import org.example.nivell1.exercici5.module.DirectoryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DirectoryManagerTest {

    @Test
    void testSerializationAndDeserialization() throws Exception {
        DirectoryManager manager = new DirectoryManager("src/main/resources/config.properties");

        DirectoryInfo originalInfo = new DirectoryInfo("testDirectory",
                List.of("archivo1.txt", "archivo2.txt"));

        String filePath = "test_directory.ser";

        manager.serializeDirectory(originalInfo, filePath);

        DirectoryInfo deserializedInfo = manager.deserializeDirectory(filePath);

        assertNotNull(deserializedInfo);
        assertEquals(originalInfo.getPath(), deserializedInfo.getPath());
        assertEquals(originalInfo.getFiles(), deserializedInfo.getFiles());

        Files.deleteIfExists(Path.of(filePath));
    }
}
