package chap17_datestimes.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeTest {

    @Test
    public void currentTimeMillis(){
        long startTime = System.currentTimeMillis();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " +
                    System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void createAUniqueUserID(){
        String userID = "user" + System.currentTimeMillis();

        System.out.println(userID);
        Assert.assertTrue(userID.startsWith("user"));
        Assert.assertTrue(Long.valueOf(userID.replace("user",""))>1000L);
    }
}
