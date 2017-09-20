package javafortesters.domainentities.interim.inheritance;


import javafortesters.domainobject.TestAppEnv;

public class User {
    private String username;
    private String password;
    private TestAppEnv testAppEnv;

    public User(){
        this("username", "password");
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.testAppEnv = new TestAppEnv();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl(){
        return this.testAppEnv.getUrl();
    }
}
