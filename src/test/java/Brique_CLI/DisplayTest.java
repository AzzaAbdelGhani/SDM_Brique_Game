package Brique_CLI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DisplayTest {

    @Test
    public void checkStringInputIsYes(){
        assertTrue(Display.IsInputYes("Yes"));
    }
}
