package chap15_stringsrevisited.exercises;

import javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserPasswordExceptionsTest {

    @Test(expectedExceptions = InvalidPassword.class)
    public void passwordMustHaveANumber() throws InvalidPassword {
        User aUser = new User("username", "Password");
        Assert.fail("User creation should have thrown an exception");
    }

    @Test(expectedExceptions = InvalidPassword.class)
    public void passwordMustHaveAnUppercase() throws InvalidPassword {
        User aUser = new User("username", "1assword");
        Assert.assertEquals("1assword", aUser.getPassword());
    }

    @Test (expectedExceptions = InvalidPassword.class)
    public void passwordMustBeGreaterThan6Chars() throws InvalidPassword {
        User aUser = new User("username", "I23456");
        Assert.assertEquals("I23456", aUser.getPassword());
    }

    @Test
    public void multipleUppercaseAndDigitsAllowed() throws InvalidPassword {
        User aUser = new User("username", "I23456T");
        Assert.assertEquals("I23456T", aUser.getPassword());

        aUser = new User("username", "12B4S6TP");
        Assert.assertEquals("12B4S6TP", aUser.getPassword());
    }

    @Test
    public void canStillCreateDefaultUser(){
        User aUser = new User();
        Assert.assertEquals(aUser.getPassword(), "Passw0rd");
    }

    @Test
    public void validPasswordMatchExamples() throws InvalidPassword {
        User aUser = new User("username", "Password2");
        Assert.assertEquals("Password2", aUser.getPassword());

        aUser = new User("username", "Pas5word");
        Assert.assertEquals("Pas5word", aUser.getPassword());

        aUser = new User("username", "I1234567");
        Assert.assertEquals("I1234567", aUser.getPassword());

        aUser = new User("username", "1234S67");
        Assert.assertEquals("1234S67", aUser.getPassword());

        aUser = new User("username", "123456T");
        Assert.assertEquals("123456T", aUser.getPassword());

        aUser = new User("username", "I1234567ten");
        Assert.assertEquals("I1234567ten", aUser.getPassword());
    }
}
