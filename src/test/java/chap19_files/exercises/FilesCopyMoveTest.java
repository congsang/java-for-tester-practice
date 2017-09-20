package chap19_files.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesCopyMoveTest {

    @Test
    public void copyFile() throws IOException {
        File copyThis = writeTheTestDataFile();
        File toThis = new File(copyThis.getCanonicalPath() + ".copy");

        Assert.assertEquals(toThis.exists(), false);

        Files.copy(copyThis.toPath(), toThis.toPath());

        Assert.assertEquals(toThis.exists(), true);
        Assert.assertEquals(copyThis.length(), toThis.length());
    }

    @Test
    public void moveFile() throws IOException {
        File moveThis = writeTheTestDataFile();
        File toThis = new File(moveThis.getCanonicalPath() + ".moved");

        Assert.assertEquals(moveThis.exists(), true);
        Assert.assertEquals(toThis.exists(), false);

        Files.move(moveThis.toPath(), toThis.toPath(),
                REPLACE_EXISTING, ATOMIC_MOVE);

        Assert.assertEquals(toThis.exists(), true);
        Assert.assertEquals(moveThis.exists(), false);
    }

    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);
        PrintWriter print = new PrintWriter(new BufferedWriter((new FileWriter(outputFile))));
        for (int lineNumber = 1; lineNumber < 6; lineNumber++) {
            print.println("line " + lineNumber);
        }
        print.close();
        return outputFile;
    }
}
