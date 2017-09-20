package chap21_collectionsrevisited.exercises;

import javafortesters.domainentities.interim.comparator.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExercisesUserClassSeeComparatorInActionTest {

    @Test
    public void sortedSetWithComparatorForUserWithNoValEqualZero(){
        User bob = new User("Bob", "pA55Word");   // 11
        User dupebob = new User("Bob", "hello");
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User dupebob2 = new User("Bob", "BobsMightyBigBobPassword");
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparatorDisallowDupes());

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

    private class UserComparatorDisallowDupes implements Comparator {

        public int compare(Object oUser1, Object oUser2) {
            User user1 = (User)oUser1;
            User user2 = (User)oUser2;

            if(user1.getUsername().compareTo(user2.getUsername())==0){
                return 0;
            }

            int user1Comparator = user1.getPassword().length() +
                    user1.getUsername().length();

            int user2Comparator = user2.getPassword().length() +
                    user2.getUsername().length();

            int val =  user1Comparator - user2Comparator;

            if(val==0){
                val = user1.getUsername().compareTo(user2.getUsername());
            }

            System.out.println("Compare " + user1.getUsername() +
                    " with " + user2.getUsername() + " = " + val);
            return val;
        }
    }
}
