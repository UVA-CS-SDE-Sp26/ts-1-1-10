package cipher;

import java.nio.file.Path;

public class CipherService {

    private final CipherKeyLoader loader;

    public CipherService(CipherKeyLoader loader) {
        this.loader = loader;
    }

    /** Deciphers text using the key located at keyPath. Unmapped chars are returned unchanged. */
    public String decipher(String cipherText, Path keyPath) {
        if (cipherText == null) return null;

        CipherKey key = loader.load(keyPath);

        StringBuilder sb = new StringBuilder(cipherText.length());
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            Character plain = key.decipherChar(c);
            sb.append(plain != null ? plain : c);
        }
        return sb.toString();
    }
}
