package p5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class VoidExampleMethodRefactorTest {

    private VoidExampleMethodRefactor voidExampleMethodRefactor = new VoidExampleMethodRefactor();

    @Test
    void shouldDeleteExistingFile(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("testFile.txt"));
        // when
        boolean deleted = voidExampleMethodRefactor.delete(tempDir, "testFile.txt");
        // then
        assertThat(deleted).isTrue();
    }

    @Test
    void shouldNotDeleteNoneExistingFile(@TempDir Path tempDir) throws IOException {
        // when
        boolean deleted = voidExampleMethodRefactor.delete(tempDir, "testFile.txt");
        // then
        assertThat(deleted).isFalse();
    }

    @Test
    void shouldNotDeleteNoneEmptyDir(@TempDir Path tempDir) throws IOException {
        // given
        Files.createFile(tempDir.resolve("testFile.txt"));
        // when
        boolean deleted = voidExampleMethodRefactor.delete(tempDir, "");
        // then
        assertThat(deleted).isFalse();
    }
}