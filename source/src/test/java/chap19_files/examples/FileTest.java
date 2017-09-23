package chap19_files.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {

    @Test
    public void aNewFileDoesNotCreateAFile() throws IOException {
        File aTempFile = new File("d:/tempJavaForTesters.txt");
        Assert.assertEquals(aTempFile.exists(), false);
    }

    @Test
    public void pathsGetExampleForCrossPlatform() throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");

        // you would probably just use File for this one
        File theFile = Paths.get(tempDir, "file.txt").toFile();
        Assert.assertEquals(theFile.getAbsolutePath(),
                tempDir.endsWith(File.separator + "file.txt"));

        theFile = Paths.get(tempDir, "temp1", "file.txt").toFile();
        Assert.assertEquals(theFile.getAbsolutePath(),
                tempDir.endsWith(String.format("%s%s%1$s%s",
                        File.separator, "temp1", "file.txt")));

        theFile = Paths.get(tempDir, "temp1","temp2", "temp3", "file.txt").toFile();
        Assert.assertEquals(theFile.getAbsolutePath(),
                tempDir.endsWith(String.format("%s%s%1$s%s%1$s%s%1$s%s",
                        File.separator, "temp1", "temp2", "temp3", "file.txt")));
    }


/*
    @Test
    public void createAFileAndDeleteIt() throws IOException {
        File aTempFile = new File("d:/tempJavaForTesters.txt");
        Assert.assertEquals();(aTempFile.exists(), false));
        aTempFile.createNewFile();
        Assert.assertEquals();(aTempFile.exists(), true));
        aTempFile.delete();
        Assert.assertEquals();(aTempFile.exists(), false));
    }
*/

    // since the above example commented out
    // this checks that the basic code works
    // in a platform independent way using Paths
    @Test
    public void createAFileAndDeleteItCodeCheck() throws IOException {
        /* for documentation of simple path
        File aTempFile = Paths.get("d:", "tempJavaForTesters.txt").toFile();
        */

        String tempDir = System.getProperty("java.io.tmpdir");
        File aTempFile = Paths.get(tempDir, "tempJavaForTesters.txt").toFile();

        Assert.assertEquals(aTempFile.exists(), false);

        aTempFile.createNewFile();
        Assert.assertEquals(aTempFile.exists(), true);

        aTempFile.delete();
        Assert.assertEquals(aTempFile.exists(), false);
    }

    @Test
    public void createAFileAndDeleteItAlternativeConstructor() throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        File aTempFile = new File(tempDir, "tempJavaForTesters.txt");
        Assert.assertEquals(aTempFile.exists(), false);

        aTempFile.createNewFile();
        Assert.assertEquals(aTempFile.exists(), true);

        aTempFile.delete();
        Assert.assertEquals(aTempFile.exists(), false);
    }

    @Test
    public void createLongerPathExample(){
        String tempDirectory = System.getProperty("java.io.tmpdir");
        File aFile = new File(tempDirectory);
        aFile = new File(aFile, "1");
        aFile = new File(aFile, "2");
        aFile = new File(aFile, "3");
        aFile = new File(aFile, "4");

        // make it an easy cross platform comparison
        String filePathWithDots = aFile.getAbsolutePath().replace(File.separator, ".");
        Assert.assertTrue(filePathWithDots.endsWith(".1.2.3.4"));

        Path aPath = Paths.get(tempDirectory, "1", "2", "3", "4");
        Assert.assertEquals(aFile.getAbsolutePath(), aPath.toFile().getAbsolutePath());
    }

    @Test
    public void canonicalVsAbsolute() throws IOException {
        String tempDirectory = System.getProperty("java.io.tmpdir");

        // create a directory path
        // temp\<millis>\1\2\3\4\5
        // temp\<millis>\1
        // temp\<millis>\1\2\3\4\..\..\..
        // temp\<millis>\1\2\..\..\..\1

        String currentMillis = String.valueOf(System.currentTimeMillis());

        File bFile = new File(tempDirectory);
        System.out.println(bFile.getName());

        File aFile = new File(tempDirectory, currentMillis);
        File oneDirectory = new File(aFile, "1");
        aFile = new File(oneDirectory, "2");
        aFile = new File(aFile, "3");
        aFile = new File(aFile, "4");
        aFile = new File(aFile, "5");

        aFile.mkdirs();

        System.out.println(oneDirectory.getAbsolutePath());
        System.out.println(oneDirectory.getCanonicalPath());
        System.out.println(aFile.getAbsolutePath());

        Assert.assertTrue(oneDirectory.getCanonicalPath().endsWith(oneDirectory.getAbsolutePath()));

        File relative = new File(tempDirectory, currentMillis);
        relative = new File(relative, "1");
        relative = new File(relative, "2");
        relative = new File(relative, "3");
        relative = new File(relative, "4");
        relative = new File(relative, "..");   //3
        relative = new File(relative, "..");   //2
        relative = new File(relative, "..");   //1

        System.out.println(relative.getAbsolutePath());

        Assert.assertTrue(relative.getCanonicalPath().endsWith(oneDirectory.getAbsolutePath()));

        relative = new File(tempDirectory, currentMillis);
        relative = new File(relative, "1");
        relative = new File(relative, "2");
        relative = new File(relative, "..");   //1
        relative = new File(relative, "..");   //millis
        relative = new File(relative, "1");   //1

        System.out.println(relative.getAbsolutePath());

        Assert.assertTrue(relative.getCanonicalPath().endsWith(oneDirectory.getAbsolutePath()));
    }

    @Test
    public void mkdirsCreatesIntermediateDirs(){
        String tempDirectory = System.getProperty("java.io.tmpdir");

        File aDirectory = Paths.get(tempDirectory,
                Long.toString(System.currentTimeMillis()),
                Long.toString(System.currentTimeMillis()))
                .toFile();

        System.out.println(aDirectory.getAbsolutePath());

        Assert.assertEquals(aDirectory.mkdir(), false);
        Assert.assertEquals(aDirectory.mkdirs(), true);
    }

    @Test
    public void mkdirsCreatesDirectories(){
        String tempDirectory = System.getProperty("java.io.tmpdir");

        File aFilePath = Paths.get(tempDirectory,
                Long.toString(System.currentTimeMillis()),
                "test.tmp")
                .toFile();

        System.out.println(aFilePath.getAbsolutePath());

        // mkdir won't create this because it temp/millis/test.tmp

        Assert.assertEquals(aFilePath.mkdir(), false);
        Assert.assertEquals(aFilePath.exists(), false);

        // mkdir will create because it just the temp/millis
        File aDirectoryPath = Paths.get(tempDirectory,
                Long.toString(System.currentTimeMillis()))
                .toFile();

        Assert.assertEquals(aDirectoryPath.mkdir(), true);
    }

    @Test
    public void fileAndPathSeparator(){
        Assert.assertTrue( File.separator.equals("\\") || File.separator.equals("/"),"Unrecognised OS file separator");
        Assert.assertTrue(File.pathSeparator.equals(";") || File.pathSeparator.equals(":"),"Unrecognised OS path separator");
    }

    @Test
    public void createATempFileAndDeleteOnExit(){
        try {
            File aTempFile = File.createTempFile("prefix", "suffix");
            aTempFile.deleteOnExit();

            System.out.println(aTempFile.getAbsolutePath());

            String tempDirectory = System.getProperty("java.io.tmpdir");

            Assert.assertEquals( aTempFile.getName().startsWith("prefix"), true);
            Assert.assertEquals( aTempFile.getName().endsWith("suffix"), true);

            Assert.assertTrue(System.getProperty("java.io.tmpdir").
                    startsWith(aTempFile.getParent()));

            Assert.assertEquals(aTempFile.getAbsolutePath().endsWith("suffix"), true);
            Assert.assertEquals(aTempFile.getAbsolutePath().startsWith(
                    System.getProperty("java.io.tmpdir")), true);

            Assert.assertEquals(aTempFile.getCanonicalPath().endsWith("suffix"),
                    true);
            Assert.assertEquals(aTempFile.getCanonicalPath().contains(
                    System.getProperty("java.io.tmpdir")), true);

            Assert.assertEquals(aTempFile.exists(), true);

            // the prefix needs to be 3 chars or longer otherwise java.lang.IllegalArgumentException thrown
            String userDirectory = System.getProperty("user.dir");

            aTempFile = File.createTempFile("pre", null,
                    new File(System.getProperty("user.dir")));

            System.out.println(aTempFile.getAbsolutePath());
            aTempFile.deleteOnExit();

            Assert.assertEquals(aTempFile.getAbsolutePath().endsWith(".tmp"), true);
            Assert.assertEquals(aTempFile.getAbsolutePath().startsWith(userDirectory), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listTempDirectory(){
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        String[] fileList = tempDir.list();

        for(String fileInList : fileList){
            System.out.println(fileInList);
        }
    }
}
