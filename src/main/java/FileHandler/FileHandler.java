package FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {

    private final Path dataDir;

    // Default constructor for actual program use (expects ./data)
    public FileHandler() {
        this(Paths.get("data"));
    }

    // Constructor for tests / dependency injection
    public FileHandler(Path dataDir) {
        this.dataDir = dataDir;
    }

    public List<String> listFiles() throws FileNotFoundException {
        ensureDataDirExists();

        try (Stream<Path> stream = Files.list(dataDir)) {
            return stream
                    .filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // If directory exists but can't be read, treat as "not found" for caller simplicity
            throw new FileNotFoundException("Unable to list files in data directory: " + dataDir);
        }
    }

    public String readFile(String filename) throws FileNotFoundException {
        validateFilename(filename);
        ensureDataDirExists();

        Path filePath = dataDir.resolve(filename).normalize();

        // Enforce that the resolved path stays within dataDir
        if (!filePath.startsWith(dataDir.normalize())) {
            throw new IllegalArgumentException("Invalid filename.");
        }

        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to read file: " + filename);
        }
    }

    private void ensureDataDirExists() throws FileNotFoundException {
        if (!Files.exists(dataDir) || !Files.isDirectory(dataDir)) {
            throw new FileNotFoundException("Data directory not found: " + dataDir);
        }
    }

    private void validateFilename(String filename) {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename must not be blank.");
        }
        // Keep it simple: no slashes/backslashes
        if (filename.contains("/") || filename.contains("\\") || filename.contains("..")) {
            throw new IllegalArgumentException("Invalid filename.");
        }
    }
}
