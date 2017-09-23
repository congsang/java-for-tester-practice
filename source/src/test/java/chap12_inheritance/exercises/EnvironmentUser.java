package chap12_inheritance.exercises;

import javafortesters.domainentities.User;
import javafortesters.domainobject.TestAppEnv;

public class EnvironmentUser extends User {

    public String getUrl() {
        return TestAppEnv.getUrl();
    }
}
