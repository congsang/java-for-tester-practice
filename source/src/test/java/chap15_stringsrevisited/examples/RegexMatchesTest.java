package chap15_stringsrevisited.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegexMatchesTest {

    @Test
    public void checkMatchesFunction() {
        String mustIncludeADigit = ".*[0123456789]+.*";

        Assert.assertEquals("invalid".matches(mustIncludeADigit), false);
        Assert.assertEquals("Invalid".matches(mustIncludeADigit), false);
        Assert.assertEquals("".matches(mustIncludeADigit), false);
        Assert.assertEquals("   ".matches(mustIncludeADigit), false);

        Assert.assertEquals("12345678".matches(mustIncludeADigit), true);
        Assert.assertEquals("1nvalid".matches(mustIncludeADigit), true);
        Assert.assertEquals("1nval1d".matches(mustIncludeADigit), true);
        Assert.assertEquals("inval1d".matches(mustIncludeADigit), true);
        Assert.assertEquals("invali6".matches(mustIncludeADigit), true);


        String mustIncludeUppercase = ".*[A-Z]+.*";

        Assert.assertEquals("invalid".matches(mustIncludeUppercase), false);
        Assert.assertEquals("".matches(mustIncludeUppercase), false);
        Assert.assertEquals("   ".matches(mustIncludeUppercase), false);
        Assert.assertEquals("12345678".matches(mustIncludeUppercase), false);

        Assert.assertEquals("Valid".matches(mustIncludeUppercase), true);
        Assert.assertEquals("val1D".matches(mustIncludeUppercase), true);
        Assert.assertEquals("vaL1d".matches(mustIncludeUppercase), true);
        Assert.assertEquals("vaLid".matches(mustIncludeUppercase), true);
        Assert.assertEquals("VALID".matches(mustIncludeUppercase), true);
    }
}
