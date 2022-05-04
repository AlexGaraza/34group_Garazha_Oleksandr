package ex00;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * “естирование
 * разаработанных классов
 *
 * @author Vitaliy
 * @version 0
 */
@SuppressWarnings("SpellCheckingInspection")
public class MainTest {
    @Test
    public void testArgs() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[] {"Test ex00.Main"});
        assertEquals("Test ex00.Main", outContent.toString()
                .replaceAll("\r", "").replaceAll("\n", ""));
    }
}
