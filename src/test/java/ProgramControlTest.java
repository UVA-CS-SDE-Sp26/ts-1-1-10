import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProgramControlTest {

    @Test
    void decipher() throws FileNotFoundException {
        ProgramControl program = new ProgramControl();
        program.setFileContent("bcd");
        assertEquals("abc", program.decipherTest());
    }

    @Test
    void keyTest() throws FileNotFoundException {
        String[] args = new String[2];
        args[0] = "01";
        args[1] = "02";
        ProgramControl program = new ProgramControl(args);
        assertEquals("02", program.getKey());
    }

    @Test
    void fileNameTest() throws FileNotFoundException {
        String[] args = new String[1];
        args[0] = "01";
        ProgramControl program = new ProgramControl(args);
        assertEquals("01", program.getFileNumber());
    }


}