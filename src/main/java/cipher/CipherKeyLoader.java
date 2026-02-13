package cipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherKeyLoader {

    private final CipherKeyValidator validator;

    public CipherKeyLoader(CipherKeyValidator validator) {
        this.validator = validator;
    }

    public CipherKey load(Path keyPath) {
        final List<String> lines;
        try {
            lines = Files.readAllLines(keyPath);
        } catch (IOException e) {
            throw new InvalidCipherKeyException("Unable to read key file at: " + keyPath, e);
        }

        if (lines.size() < 2) {
            throw new InvalidCipherKeyException("Key file must contain exactly 2 lines (plain, cipher).");
        }

        String plain = lines.get(0);
        String cipher = lines.get(1);

        validator.validate(plain, cipher);

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < plain.length(); i++) {
            map.put(cipher.charAt(i), plain.charAt(i)); // cipher -> plain (DECIPHER)
        }
        return new CipherKey(map);
    }
}