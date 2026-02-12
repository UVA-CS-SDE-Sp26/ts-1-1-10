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

    public String decipher(String input) {
        return service.decipher(input, defaultKeyPath);
    }
}