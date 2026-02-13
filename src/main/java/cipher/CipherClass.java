package cipher;

import java.nio.file.Path;

public class CipherClass {

    private final CipherService service;
    private final Path defaultKeyPath;

    public CipherClass() {
        this.defaultKeyPath = Path.of("ciphers", "key.txt");
        this.service = new CipherService(
                new CipherKeyLoader(new CipherKeyValidator())
        );
    }

    // Default key
    public String decipher(String input) {
        return service.decipher(input, defaultKeyPath);
    }

    // Alternate key
    public String decipher(String input, String keyFileName) {
        Path keyPath = Path.of("ciphers", keyFileName);
        return service.decipher(input, keyPath);
    }
}
