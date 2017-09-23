package chap19_files.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void canCreateGetAndSetProperties() {
        Properties properties = new Properties();

        Assert.assertEquals(properties.size(), 0);

        properties.setProperty("browser", "firefox");
        properties.setProperty("port", "80");

        Assert.assertEquals(properties.getProperty("browser"), "firefox");
        Assert.assertEquals(properties.getProperty("port"), "80");
        Assert.assertEquals(properties.getProperty("missing", "default"), "default");
        Assert.assertEquals(properties.containsKey("browser"), true);
    }

    @Test
    public void canDisplayTheProperties() {
        Properties properties = new Properties();
        properties.setProperty("browser", "firefox");
        properties.setProperty("port", "80");

        Assert.assertEquals(properties.stringPropertyNames().size(), (2));

        for (String key : properties.stringPropertyNames()) {
            System.out.println("Key: " + key + " " +
                    "Value: " + properties.getProperty(key));
        }

        properties.list(System.out);
    }

    @Test
    public void canAccessSystemProperties() {
        String workingDirectory = System.getProperty("user.dir");

        String resourceFilePath = workingDirectory +
                "/src/test/resources/" +
                "property_files/" +
                "static_example.properties";

        Properties sys = System.getProperties();
        sys.list(System.out);
    }

    @Test
    public void exampleSetWebdriverChromeIfNotSet() {
        if (!System.getProperties().containsKey("webdriver.chrome.driver")) {
            String currentDir = System.getProperty("user.dir");
            String chromeDriverLocation
                    = currentDir +
                    "/../tools/chromedriver/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        }
    }

    @Test
    public void simpleSaveLoadPropertiesFile() throws IOException {
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourceFilePath = new File(tempDirectory, "tempFileForPropertiesStoreTest.properties").getAbsolutePath();

        Properties saved = new Properties();
        saved.setProperty("prop1", "Hello");
        saved.setProperty("prop2", "World");

        FileOutputStream outputFile = new FileOutputStream(tempResourceFilePath);
        saved.store(outputFile, "Hello There World");
        outputFile.close();

        FileReader propertyFileReader = new FileReader(tempResourceFilePath);
        Properties loaded = new Properties();

        try {
            loaded.load(propertyFileReader);
        } finally {
            propertyFileReader.close();
        }

        Assert.assertEquals(loaded.getProperty("prop1"), "Hello");
        Assert.assertEquals(loaded.getProperty("prop2"), "World");

        new File(tempResourceFilePath).delete();
    }
}
