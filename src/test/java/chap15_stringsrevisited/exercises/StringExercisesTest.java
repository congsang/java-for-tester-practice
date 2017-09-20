package chap15_stringsrevisited.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class StringExercisesTest {

    @Test
    public void tryUsingTheOtherEscapeCharactersOutputToConsole() {
        System.out.println("New lines, and Tabs");
        String firstLine = "|first line\n";
        String secondLine = "|\tsecond line\n";
        String thirdLine = "|\t\tthird line\n";
        String fullLine = firstLine + secondLine + thirdLine;
        System.out.println(fullLine);

        System.out.println("Carriage return after each word");
        System.out.println("one\rtwo\rthree\rfour\rfive\r");

        System.out.println("Backspace after each word");
        System.out.println("one\btwo\bthree\bfour\bfive\b");

        System.out.println("Quotes and slashes");
        System.out.println("Bob\'s toy said \"DOS uses \'\\\'\"");
    }

    @Test
    public void canConstructStrings() {
        String empty = new String();
        Assert.assertEquals(empty.length(), 0);

        char[] cArray = {'2', '3'};
        Assert.assertEquals(new String(cArray), "23");
        Assert.assertEquals(new String(cArray, 1, 1), "3");

        byte[] bArray = "hello there".getBytes();
        Assert.assertEquals(new String(bArray, 3, 3), "lo ");

        byte[] b8Array = new byte[0];
        try {
            b8Array = "hello there".getBytes("UTF8");
            Assert.assertEquals(new String(b8Array, 3, 3, "UTF8"), "lo ");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String hello = new String("hello" + " " + "there");
        Assert.assertEquals(hello, "hello there");
    }


    @Test
    public void exerciseUseRegionMatches() {
        String hello = "Hello fella";
        Assert.assertTrue(hello.regionMatches(true, 9, "young lady", 6, 2));
    }
}