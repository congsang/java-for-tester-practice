package chap13_moreexceptions.examples;

import javafortesters.domainentities.interim.exceptions.User;
import javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customExceptionsTest {

    @Test
    public void canCreateDefaultUserWithoutHandlingException(){
        User aUser = new User();
        Assert.assertEquals("username", aUser.getUsername());
        Assert.assertEquals("password", aUser.getPassword());
    }

    /*@Test
    public void haveToCatchIllegalPasswordForParamConstructor(){
        User aUser = new User("me","wrong");
        Assert.fail("An exception should have been thrown");
    }

    @Test(expectedExceptions = InvalidPassword.class)
    public void propogateIllegalPasswordExpected() throws InvalidPassword {
        User aUser = new User("me", "bad");
    }*/
}
