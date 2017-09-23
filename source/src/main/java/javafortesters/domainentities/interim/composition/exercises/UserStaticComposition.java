package javafortesters.domainentities.interim.composition.exercises;

import javafortesters.domainobject.TestAppEnv;

public class UserStaticComposition {
    public String username;
    public String password;

    public UserStaticComposition(String username, String password) {
        this.username = username;
        this.password = password;
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
        return TestAppEnv.getUrl();
    }
}
