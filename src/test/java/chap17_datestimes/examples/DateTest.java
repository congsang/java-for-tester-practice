package chap17_datestimes.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class DateTest {

    @Test
    public void dateExploration(){
        Date date = new Date();
        Date equivDate1 = new Date();
        Date equivDate2 = new Date(System.currentTimeMillis());

        System.out.println(date.getTime());
        System.out.println(System.currentTimeMillis());

        Assert.assertEquals(equivDate1, equivDate2);

        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(date.toString());

        long oneWeekFromNowTime = date.getTime();
        oneWeekFromNowTime = oneWeekFromNowTime +
                (1000 * 60 * 60 * 24 * 7);
        Date oneWeekFromNow = new Date(oneWeekFromNowTime);
        System.out.println(oneWeekFromNow.toString());

        Assert.assertEquals(oneWeekFromNow.after(date), true);
        Assert.assertEquals(date.before(oneWeekFromNow), true);
        Assert.assertEquals(date.compareTo(oneWeekFromNow), -1);
        Assert.assertEquals(oneWeekFromNow.compareTo(date), 1);

        Date sameDate = new Date();
        sameDate.setTime(date.getTime());
        Assert.assertEquals(date.equals(sameDate), true);
        Assert.assertEquals(date.compareTo(sameDate), 0);
    }
}
