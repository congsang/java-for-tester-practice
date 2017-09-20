package chap17_datestimes.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

public class DateTimeExercisesTest {

    @Test
    public void nanoTime(){
        long startTime = System.nanoTime();

        for(int x=0; x < 10; x++){
            System.out.println("Current Time " + System.nanoTime());
        }

        long endTime = System.nanoTime();
        System.out.println("Total Time " + (endTime - startTime));
    }

    @Test
    public void createAUniqueUserIDAllChars(){

        String initialUserID = "user" + System.currentTimeMillis();
        System.out.println(initialUserID);

        String userID = initialUserID;

        for(int x = 0; x< 10; x++){
            String charReplacement = "" + ((char)('A'+x));
            String intToReplace = String.valueOf(x);
            userID = userID.replace( intToReplace, charReplacement);
        }

        Assert.assertEquals(userID.contains("0"), false);
        Assert.assertEquals(userID.contains("1"), false);
        Assert.assertEquals(userID.contains("2"), false);
        Assert.assertEquals(userID.contains("3"), false);
        Assert.assertEquals(userID.contains("4"), false);
        Assert.assertEquals(userID.contains("5"), false);
        Assert.assertEquals(userID.contains("6"), false);
        Assert.assertEquals(userID.contains("7"), false);
        Assert.assertEquals(userID.contains("8"), false);
        Assert.assertEquals(userID.contains("9"), false);

        Assert.assertEquals(initialUserID.length(), userID.length());

        System.out.println(userID);
    }

    @Test
    public void writeCalendarToStringToConsole(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
    }

    @Test
    public void useOtherCalendarConstants(){
        Calendar cal = Calendar.getInstance();

        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);
        Assert.assertEquals(cal.get(Calendar.MONTH), Calendar.DECEMBER);
        Assert.assertEquals(cal.get(Calendar.YEAR), 2013);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 15);
        Assert.assertEquals(cal.get(Calendar.HOUR_OF_DAY), 23);
        Assert.assertEquals(cal.get(Calendar.MINUTE), 39);
        Assert.assertEquals(cal.get(Calendar.HOUR), 11);
        Assert.assertEquals(cal.get(Calendar.AM_PM), Calendar.PM);
    }


    @Test
    public void experimentWithCalendarConstants(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23, 39, 54);


        Assert.assertEquals(cal.get(Calendar.DAY_OF_WEEK), 1);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_WEEK), Calendar.SUNDAY);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_YEAR), 349);

        // week of month depends on first day of week
        // some places use SUNDAY as first day
        // set to MONDAY for our calculation
        // and control Minimal Days in First Week
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(6);
        Assert.assertEquals(cal.get(Calendar.WEEK_OF_MONTH), 2);

        // Week of the year, similarly requires the
        // config to control first day
        Assert.assertEquals(cal.get(Calendar.WEEK_OF_YEAR), 50);
    }

    @Test
    public void incrementAndDecrementOtherFields(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.add(Calendar.YEAR,-2);
        cal.add(Calendar.MONTH, -6);
        cal.add(Calendar.DAY_OF_MONTH, -12);

        Assert.assertEquals(cal.get(Calendar.YEAR), 2011);
        Assert.assertEquals(cal.get(Calendar.MONTH), Calendar.JUNE);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 3);

        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        // bump it forward to 3rd June 2014,
        // then pull it back
        cal.add(Calendar.DAY_OF_MONTH, 19);
        cal.add(Calendar.MONTH, 5);
        cal.add(Calendar.YEAR,-3);

        Assert.assertEquals(cal.get(Calendar.YEAR), 2011);
        Assert.assertEquals(cal.get(Calendar.MONTH), Calendar.JUNE);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 3);
    }

    @Test
    public void rollCalendar(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.roll(Calendar.DAY_OF_MONTH,17);

        Assert.assertEquals(cal.get(Calendar.YEAR), 2013);
        Assert.assertEquals(cal.get(Calendar.MONTH), Calendar.DECEMBER);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 1);

        cal.set(2013, Calendar.DECEMBER, 15, 23,39, 54);

        cal.add(Calendar.DAY_OF_MONTH,17);
        Assert.assertEquals(cal.get(Calendar.YEAR), 2014);
        Assert.assertEquals(cal.get(Calendar.MONTH), Calendar.JANUARY);
        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), 1);
    }

}
