import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramControlTest {

    @Test
    void decipher() {
        ProgramControl program = new ProgramControl();
        program.setFileContent("bcd");
        assertEquals("abc", program.decipher());
    }
}