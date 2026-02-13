package FileHandler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @TempDir
    Path tempDir;

    @Test
    void listFiles_returnsSortedFilenames_onlyFiles() throws Exception {
        Path dataDir = Files.createDirectory(tempDir.resolve("data"));
        Files.writeString(dataDir.resolve("b.txt"), "B");
        Files.writeString(dataDir.resolve("a.txt"), "A");
        Files.createDirectory(dataDir.resolve("subfolder")); // should be ignored

        FileHandler fh = new FileHandler(dataDir);

        List<String> files = fh.listFiles();
        assertEquals(List.of("a.txt", "b.txt"), files);
    }

    @Test
    void readFile_returnsContents_whenFileExists() throws Exception {
        Path dataDir = Files.createDirectory(tempDir.resolve("data"));
        Files.writeString(dataDir.resolve("wiki.txt"), "hello\nworld\n");

        FileHandler fh = new FileHandler(dataDir);

        String contents = fh.readFile("wiki.txt");
        assertEquals("hello\nworld\n", contents);
    }

    @Test
    void readFile_throwsFileNotFound_whenMissing() throws Exception {
        Path dataDir = Files.createDirectory(tempDir.resolve("data"));
        FileHandler fh = new FileHandler(dataDir);

        assertThrows(FileNotFoundException.class, () -> fh.readFile("nope.txt"));
    }

    @Test
    void listFiles_throwsFileNotFound_whenDataDirMissing() {
        Path dataDir = tempDir.resolve("data"); // not created
        FileHandler fh = new FileHandler(dataDir);

        assertThrows(FileNotFoundException.class, fh::listFiles);
    }

    @Test
    void readFile_rejectsPathTraversal() throws Exception {
        Path dataDir = Files.createDirectory(tempDir.resolve("data"));
        FileHandler fh = new FileHandler(dataDir);

        assertThrows(IllegalArgumentException.class, () -> fh.readFile("../secret.txt"));
        assertThrows(IllegalArgumentException.class, () -> fh.readFile("subdir/evil.txt"));
    }
}
