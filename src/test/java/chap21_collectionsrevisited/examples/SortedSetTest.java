package chap21_collectionsrevisited.examples;

import javafortesters.domainentities.User;
import javafortesters.domainentities.UserComparator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {

    @Test
    public void canRetrieveFirstFromSortedSet() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        Assert.assertEquals("c", alphaset.first());

        alphaset.add("d");
        Assert.assertEquals("c", alphaset.first());

        alphaset.add("b");
        Assert.assertEquals("b", alphaset.first());

        alphaset.add("a");
        Assert.assertEquals("a", alphaset.first());
    }

    @Test
    public void canRetrieveLastFromSortedSet() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        Assert.assertEquals("c", alphaset.last());

        alphaset.add("b");
        Assert.assertEquals("c", alphaset.last());

        alphaset.add("d");
        Assert.assertEquals("d", alphaset.last());

        alphaset.add("a");
        Assert.assertEquals("d", alphaset.last());
    }

    @Test
    public void sortedSetCanMaintainSortOrder() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("a");
        alphaset.add("b");
        alphaset.add("a");

        Assert.assertEquals(4, alphaset.size());

        String[] alphas = new String[alphaset.size()];
        alphaset.toArray(alphas);

        Assert.assertEquals("a", alphas[0]);
        Assert.assertEquals("b", alphas[1]);
        Assert.assertEquals("c", alphas[2]);
        Assert.assertEquals("d", alphas[3]);
    }

    @Test
    public void sortedSetcanReturnHeadSet() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.headSet("c");

        Assert.assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        Assert.assertEquals("a", alphas[0]);
        Assert.assertEquals("b", alphas[1]);
    }

    @Test
    public void sortedSetcanReturnTailSet() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.tailSet("c");

        Assert.assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        Assert.assertEquals("c", alphas[0]);
        Assert.assertEquals("d", alphas[1]);
    }

    @Test
    public void sortedSetcanReturnSubSet() {
        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        alphaset.add("d");
        alphaset.add("b");
        alphaset.add("a");

        SortedSet<String> subset = alphaset.subSet("b", "d");

        Assert.assertEquals(2, subset.size());

        String[] alphas = new String[subset.size()];
        subset.toArray(alphas);

        Assert.assertEquals("b", alphas[0]);
        Assert.assertEquals("c", alphas[1]);
    }

    @Test(expectedExceptions = ClassCastException.class)
    public void sortedSetWithComparatorForUserNoComparator() {
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("TinyTim", "hello"); //12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>();

        userSortedList.add(bob);
    }

    @Test
    public void sortedSetWithComparatorForUser() {
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("TinyTim", "hello"); //12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList =
                new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(sun);
        userSortedList.add(mrBeer);

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        Assert.assertEquals(sun.getUsername(), users[0].getUsername());
        Assert.assertEquals(bob.getUsername(), users[1].getUsername());
        Assert.assertEquals(mrBeer.getUsername(), users[2].getUsername());
        Assert.assertEquals(tiny.getUsername(), users[3].getUsername());
        Assert.assertEquals(rich.getUsername(), users[4].getUsername());
    }

    @Test
    public void comparatorExcludesUsersWithSameUserName() {
        // where the username and password length is the same
        User bob = new User("Bob", "pA55Word");   // 11
        User tiny = new User("Bob", "helloBob"); //11
        User rich = new User("Bob", "12345678"); // 11
        User bigBob = new User("Bob", "123456789"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(bigBob);

        Assert.assertEquals(2, userSortedList.size());

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        Assert.assertEquals(bob.getPassword(), users[0].getPassword());
        Assert.assertEquals(bigBob.getPassword(), users[1].getPassword());
    }
}
