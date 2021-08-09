package Brique_CLI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTest {
    private static Display d = new Display();
    @Test
    public static void checkInputChar()
    {
        assertEquals(d.Check_for_Testing(), 1);
    }
}
