package chap15_stringsrevisited.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringBuilderExerciseTest {

    @Test
    public void capacitySizeIncreasesAutomaticallyWithAppend() {
        StringBuilder builder = new StringBuilder(5);
        Assert.assertEquals(builder.capacity(), 5);
        builder.append("Hello World");
        Assert.assertEquals(builder.capacity() > 5, true);
    }

    @Test
    public void writeATestToInsert() {
        StringBuilder builder = new StringBuilder();

        // insert at start
        builder.insert(0, "a");
        Assert.assertEquals(builder.toString(), "a");

        // insert to end
        builder.insert(builder.toString().length(), "b");
        Assert.assertEquals(builder.toString(), "ab");

        // insert to middle
        builder.insert(1, ".");
        Assert.assertEquals(builder.toString(), "a.b");
    }
}
