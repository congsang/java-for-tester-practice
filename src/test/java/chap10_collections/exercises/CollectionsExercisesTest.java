package chap10_collections.exercises;

import javafortesters.domainentities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class CollectionsExercisesTest {

    @Test
    public void useAForLoopInsteadOfAWhile() {
        String[] someDays = {"Tuesday", "Thursday",
                "Wednesday", "Monday",
                "Saturday", "Sunday",
                "Friday"};

        List<String> days = Arrays.asList(someDays);

        int forwhile;
        for (forwhile = 0; !days.get(forwhile).equals("Monday"); forwhile++) {
        }
        Assert.assertEquals(3, forwhile, "Monday is at position 3");
    }

    @Test
    public void createAndManipulateACollectionOfUsers() {
        Collection<User> someUsers = new ArrayList<User>();

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        Assert.assertEquals(0, someUsers.size());
        Assert.assertTrue(someUsers.isEmpty());

        someUsers.add(bob);
        someUsers.add(eris);

        Assert.assertEquals(2, someUsers.size());
        Assert.assertFalse(someUsers.isEmpty());

        Collection<User> secondUsers = new ArrayList<User>();
        User robert = new User("robert", "9assword");
        User aleister = new User("aleister", "Pass5word");
        secondUsers.add(robert);
        secondUsers.add(aleister);
        Assert.assertEquals(2, secondUsers.size());

        someUsers.addAll(secondUsers);
        Assert.assertEquals(4, someUsers.size());
        Assert.assertTrue(someUsers.containsAll(someUsers));
        Assert.assertTrue(someUsers.contains(aleister));

        secondUsers.removeAll(someUsers);
        Assert.assertEquals(0, secondUsers.size());

        someUsers.clear();
        Assert.assertEquals(0, someUsers.size());
    }

    @Test
    public void createAndManipulateAListOfUsers() {
        List<User> someUsers = new ArrayList<User>();

        Assert.assertEquals(0, someUsers.size());

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        someUsers.add(bob);
        Assert.assertEquals(1, someUsers.size());

        someUsers.add(0, eris);
        Assert.assertEquals(2, someUsers.size());

        Assert.assertEquals(1, someUsers.indexOf(bob));
        Assert.assertEquals(0, someUsers.indexOf(eris));

        someUsers.remove(0);
        Assert.assertEquals(0, someUsers.indexOf(bob));
        Assert.assertEquals(1, someUsers.size());
    }

    @Test
    public void createAndManipulateASetOfUsers() {
        Set<User> someUsers = new HashSet<>();

        Assert.assertEquals(0, someUsers.size());

        User bob = new User("bob", "Passw0rd");

        someUsers.add(bob);
        Assert.assertEquals(1, someUsers.size());

        someUsers.add(bob);
        Assert.assertEquals(1, someUsers.size());
    }

    @Test
    public void createAndManipulateAMapOfUsers() {
        Map<String, User> someUsers = new HashMap<>();

        Assert.assertEquals(0, someUsers.size());

        User bob = new User("bob", "Passw0rd");
        User eris = new User("eris", "Cha0sTime");

        someUsers.put(bob.getUsername(), bob);
        Assert.assertEquals(1, someUsers.size());

        someUsers.put(bob.getUsername(), eris);
        Assert.assertEquals(1, someUsers.size());
    }
}
