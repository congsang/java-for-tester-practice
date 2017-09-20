package chap15_stringsrevisited.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

public class StringsRevisitedTest {

    @Test
    public void aStringLiteralIsAnObject(){
        Assert.assertEquals("hello".length(), 5);
    }


    @Test
    public void canOutputStringsToTheConsole(){
        int i=4;
        System.out.println("Print an int to the console " + i);
    }

    @Test
    public void canUseEscapeSequencesInAString(){
        System.out.println("Bob said \"hello\" to his cat's friend");
        System.out.println("This a single backslash \\");
    }


    @Test
    public void canConcatenateStringsInDifferentWays(){
        String thisIs = "This ";
        String s1 = thisIs.concat("String1");
        Assert.assertEquals(s1, "This String1");

        String ps1 = "This " + "String2";
        Assert.assertEquals(ps1, "This String2");
        String ps2 = "This " + 4;
        Assert.assertEquals(ps2, "This 4");
    }

    @Test
    public void canConvertToStrings(){
        String intConcatConvert = "" + 1;
        Assert.assertEquals(intConcatConvert, "1");

        String integerIntConvert = Integer.toString(2);
        Assert.assertEquals(integerIntConvert, "2");

        String integerStringConvert = String.valueOf(3);
        Assert.assertEquals(integerStringConvert, "3");
    }

    @Test
    public void canConvertFromStrings(){
        char[] cArray = {'2','3'};
        Assert.assertEquals("23".toCharArray(), cArray);
    }

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {
        byte[] b8Array = "hello there".getBytes("UTF8");
    }
}
