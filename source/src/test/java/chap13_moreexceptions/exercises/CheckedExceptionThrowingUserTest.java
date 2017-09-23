package chap13_moreexceptions.exercises;

import javafortesters.domainentities.interim.exceptions.custom.InvalidPassword;
import javafortesters.domainentities.interim.exceptions.custom.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckedExceptionThrowingUserTest {

    @Test(expectedExceptions = InvalidPassword.class)
    public void constructUserWithException() throws InvalidPassword {
        User aUser = new User("username", "p");
    }

    @Test
    public void createDefaultUserWithNoThrowsInvalidPasswordException() {
        User aUser = new User();
        Assert.assertEquals("password", aUser.getPassword());
    }

    @Test
    public void createUserWithInvalidPasswordExceptionMessages() {
        User aUser;

        try {
            aUser = new User("username", "p");
            Assert.fail("An Invalid Password Exception should have been thrown");

        } catch (InvalidPassword e) {
            Assert.assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }

    @Test
    public void setPasswordWithInvalidPasswordExceptionMessages() {
        User aUser = new User();

        try {
            aUser.setPassword("tiny");
            Assert.fail("An Invalid Password Exception should have been thrown");

        } catch (InvalidPassword e) {
            Assert.assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }
}
