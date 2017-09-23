package domainentities;

import javafortesters.domainentities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Test
    public void canConstructANewUser(){
        User user = new User();
    }

    @Test
    public void userHasDefaultUsernameAndPassword(){
        User user = new User();

        Assert.assertEquals( "username", user.getUsername(),"default username expected");
        Assert.assertEquals( "password", user.getPassword(),"default password expected");
    }

    @Test
    public void canConstructWithUsernameAndPassword(){
        User user = new User("admin", "pA55w0rD");

        Assert.assertEquals( "admin", user.getUsername(),"given username expected");
        Assert.assertEquals( "pA55w0rD", user.getPassword(),"given password expected");
    }

    @Test
    public void canSetPasswordAfterConstructed(){
        User user = new User();

        user.setPassword("PaZZwor6");

        Assert.assertEquals( "PaZZwor6", user.getPassword(),"setter password expected");
    }
}
