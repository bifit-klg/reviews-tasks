import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.Instant;

class Copier {
    String copy(String sourceName, String targetName) throws Exception {
        if (sourceName == null || targetName == null) {
            throw new IllegalArgumentException("Nothing to copy");
        }
        var sourcePath = Paths.get(sourceName);
        var targetPath = Paths.get(targetName);
        var start = Instant.now();
        copyFiles(sourcePath, targetPath);
        var end = Instant.now();
        var duration = Duration.between(start, end);
        return String.format("%02d:%02d:%03d",
                duration.toMinutes(),
                duration.toSeconds(),
                duration.toMillis());
    }

    private void copyFiles(Path sourcePath, Path targetPath) throws Exception {
        try {
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new Exception("Cant copy");
        }
    }
}
