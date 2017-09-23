package chap12_inheritance.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnvironmentUserTest {

    @Test
    public void createAnEnvironmentUser() {
        EnvironmentUser enuser = new EnvironmentUser();

        Assert.assertEquals("username", enuser.getUsername());
        Assert.assertEquals("http://192.123.0.3:67", enuser.getUrl());
    }
}
