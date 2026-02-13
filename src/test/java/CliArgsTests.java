import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CliArgsTests {

    @Test
    void trueFile01_setsFileNumber() {
        CliArgs ui = new CliArgs(new String[]{"01"});
        assertEquals("01", ui.getFileNumber(), "File number should be '01'.");
        assertNull(ui.getErrorMessage(), "Should be no error with a valid file number.");
    }

    @Test
    void moreThanTwoArgumentGivesError() {
        CliArgs ui = new CliArgs(new String[]{"03", "key.txt", "another key"});
        assertNotNull(ui.getErrorMessage(), "Error message set here.");
    }

    @Test
    void rightFileNumber() {
        CliArgs ui = new CliArgs(new String[]{"09"});
        assertNotNull(ui.getErrorMessage(), "Error message if not files 01, 02, or 02.");
    }
}
