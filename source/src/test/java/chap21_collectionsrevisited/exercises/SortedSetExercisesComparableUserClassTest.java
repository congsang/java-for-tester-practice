package chap21_collectionsrevisited.exercises;

import javafortesters.domainentities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExercisesComparableUserClassTest {

    @Test
    public void sortedSetWithComparableUser(){
        User bob = new User("Bob", "pA55Word");   // 11
        User dupebob = new User("Bob", "hello");
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User dupebob2 = new User("Bob", "BobsMightyBigBobPassword");
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>();

        userSortedList.add(bob);
        userSortedList.add(dupebob);
        userSortedList.add(rich);
        userSortedList.add(dupebob2);
        userSortedList.add(mrBeer);

        Assert.assertEquals(3, userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        Assert.assertEquals(bob.getUsername(), users[0].getUsername());
        Assert.assertEquals(mrBeer.getUsername(), users[1].getUsername());
        Assert.assertEquals(rich.getUsername(), users[2].getUsername());
    }
}
