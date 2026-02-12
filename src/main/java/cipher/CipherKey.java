package cipher;

import java.util.Map;

public class CipherKey {
    private final Map<Character, Character> cipherToPlain;

    public CipherKey(Map<Character, Character> cipherToPlain) {
        this.cipherToPlain = Map.copyOf(cipherToPlain);
    }

    public Character decipherChar(char c) {
        return cipherToPlain.get(c); // null if unmapped
    }
}
