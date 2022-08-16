package p5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VoidExampleMethod {

    public void delete(Path path, String fileName) throws IOException {
        Files.delete(path.resolve(fileName));
    }
}
