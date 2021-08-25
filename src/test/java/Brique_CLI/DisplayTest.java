package Brique_CLI;

import Game.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTest {
    Player P1 = new Player("P1", Piece_Color.BLACK);
    Player P2 = new Player("P2", Piece_Color.WHITE);
    Board board = new Board();
    Move move = new Move(board, P1, P2);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @ParameterizedTest
    @CsvSource({"Yes", "yes", "y", "Y"})
    public void checkIfAMessageIsYes(String userInput){
        assertTrue(Display.IsInputYes(userInput));
    }

    @ParameterizedTest
    @CsvSource({"No", "n", "N", "no"})
    public void checkIfAMessageIsNo(String userInput){
        assertFalse(Display.IsInputYes(userInput));
    }

    @ParameterizedTest
    @CsvSource({"dsf", "Nooo", "Yesssss", "wepwe3oi3", "fisf8er"})
    public void checkIfAMessageIsOtherThanYesorNo(String userInput){
        System.setOut(new PrintStream(output));
        assertFalse(Display.IsInputYes(userInput));
        assertEquals("Entered a different response than yes/no, " +
                "response by default considered as no\n", output.toString());
    }

    @Test
    public void checkAnInvalidInputMessage()
    {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Display.InvalidInput();
        assertEquals("Invalid Coordinates Enter again\n", output.toString());
        System.setOut(System.out);
    }

}
