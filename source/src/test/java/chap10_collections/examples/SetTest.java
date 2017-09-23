package chap10_collections.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    @Test
    public void setExplored(){
        Set<String> seta = new HashSet<String>();
        Set<String> setb = new <String>HashSet();
        Set<String> setc = new HashSet<>();
    }

    @Test
    public void setDoesNotAllowDuplicateElements(){
        Set workdays = new HashSet();

        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");

        Assert.assertEquals(1, workdays.size());
    }
}
