package chap12_inheritance.examples;


import javafortesters.domainentities.AdminUser;
import javafortesters.domainentities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InheritanceTest {

    @Test
    public void emptyUserExampleTest(){
        EmptyUser enu = new EmptyUser();
        Assert.assertEquals("username", enu.getUsername());
        Assert.assertEquals("password", enu.getPassword());
    }

    @Test
    public void aUserHasNormalPermissions(){
        User aUser = new User();
        Assert.assertEquals("Normal", aUser.getPermission());
    }

    @Test
    public void anAdminUserDefaultConstructor(){
        AdminUser adminUser = new AdminUser();
        Assert.assertEquals("adminuser", adminUser.getUsername());
        Assert.assertEquals("password", adminUser.getPassword());
        Assert.assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasElevatedPermissions(){
        AdminUser adminUser = new AdminUser("admin","Passw0rd");
        Assert.assertEquals("admin", adminUser.getUsername());
        Assert.assertEquals("Passw0rd", adminUser.getPassword());
        Assert.assertEquals("Elevated", adminUser.getPermission());
    }
}
