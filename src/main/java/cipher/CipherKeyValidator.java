package cipher;

import java.util.HashSet;
import java.util.Set;

public class CipherKeyValidator {

    public void validate(String plainLine, String cipherLine) {
        if (plainLine == null || cipherLine == null) {
            throw new InvalidCipherKeyException("Key file must contain exactly 2 non-null lines.");
        }
        if (plainLine.length() == 0 || cipherLine.length() == 0) {
            throw new InvalidCipherKeyException("Key lines must not be empty.");
        }
        if (plainLine.length() != cipherLine.length()) {
            throw new InvalidCipherKeyException("Key lines must be the same length.");
        }

        // Ensure no duplicate chars in cipher line (would make decipher ambiguous)
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < cipherLine.length(); i++) {
            char c = cipherLine.charAt(i);
            if (!seen.add(c)) {
                throw new InvalidCipherKeyException("Cipher line contains duplicate character: '" + c + "'");
            }
        }
    }
}
