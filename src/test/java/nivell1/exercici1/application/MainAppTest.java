package nivell1.exercici1.application;

import org.example.nivell1.exercici1.application.MainApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainAppTest {

    @Test
    void testMainWithUserInput() {

        String simulatedInput = "test/directory\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        new MainApp().executeProgram();

        String output = outputStream.toString().trim();
        assertFalse(output.isEmpty());
    }
}