import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import cipher.CipherClass;

/*
    What should I test?
    - deciphering text correctly
    - handling invalid keys
    - punctuation handling
    - empty input
    - key validation failures
*/

// The class in main that this test sources everything from should be called 'CipherClass' - there is a method 'decipher' where the string is deciphered - that is what is being tested

public class CipherTest {

    // Runs once to confirm test environment is working
    @Test
    void placeholder() {
        assertTrue(true);
    }

    // Is true if the result is as expected (basic check)
    @Test
    void shouldBeEqual() {

        CipherClass cipher = new CipherClass();

        assertEquals("abc", cipher.decipher("bcd"));
    }

    // Is true if the result is also capitalized
    @Test
    void capitalizationCheck() {

        CipherClass cipher = new CipherClass();

        assertEquals("ABC", cipher.decipher("BCD"));
    }

    // Makes sure that when the key has both letters and numbers that the function still works correctly
    @Test
    void mixedInput() {

        CipherClass cipher = new CipherClass();

        assertEquals("90a", cipher.decipher("0ab"));
    }

    // Invalid keys should not trigger an error, they should just be returned as-is
    @Test
    void isInvalidEntry() {

        CipherClass cipher = new CipherClass();

        assertEquals("$#%", cipher.decipher("$#%"));
    }

    /* EXTRA TESTS NOT APPLICABLE FOR TEAM MEMBER D

    // (TEST FOR A/C) Is true if the number entered returns the specific file number (which should happen if only a number is entered)
    @Test
    void isNumberOnly() {

        CipherClass cipher = new CipherClass();

        assertNotEquals("4", cipher.decipher("5"));
    }

    // (TEST FOR A/C) Is true if the function recognizes that there is a second parameter entered (which is the '2')
    @Test
    void secondParameter() {

        CipherClass cipher = new CipherClass();

        assertNotEquals("jbjb 3", cipher.decipher("kckc 4"));
    }

    // (TEST FOR A/C) Is true if the result is not empty (makes sure that when nothing is provided, that the output is also not nothing - it should read all the available files)
    @Test
    void isBlank() {

        CipherClass cipher = new CipherClass();

        assertFalse(cipher.decipher("").isEmpty());
    }

     */

}
