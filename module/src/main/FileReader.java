import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileReader {
    List<String> readUserFile(String filePath) throws Exception {
        List<String> lines;
        var path = Paths.get(filePath);
        try (Stream<String> lineStream = Files.lines(path)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new Exception("Cant read file");
        }

        return lines;
    }
}
