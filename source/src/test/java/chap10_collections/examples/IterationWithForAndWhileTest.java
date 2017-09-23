package chap10_collections.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class IterationWithForAndWhileTest {

    @Test
    public void findMondayWithLoops() {
        String[] someDays = {"Tuesday", "Thursday",
                "Wednesday", "Monday",
                "Saturday", "Sunday",
                "Friday"};

        List<String> days = Arrays.asList(someDays);

        int forCount = 0;
        for (String day : days) {
            if (day.equals("Monday")) {
                break;
            }
            forCount++;
        }
        Assert.assertEquals(3, forCount, "Monday is at position 3");

        int loopCount;
        for (loopCount = 0; loopCount <= days.size(); loopCount++) {
            if (days.get(loopCount).equals("Monday")) {
                break;
            }
        }
        Assert.assertEquals(3, loopCount, "Monday is at position 3");


        int count = 0;
        while (!days.get(count).equals("Monday")) {
            count++;
        }
        Assert.assertEquals(3, count, "Monday is at position 3");

        int docount = -1;
        do {
            docount++;
        } while (!days.get(docount).equals("Monday"));

        Assert.assertEquals(3, docount, "Monday is at position 3");
    }
}
