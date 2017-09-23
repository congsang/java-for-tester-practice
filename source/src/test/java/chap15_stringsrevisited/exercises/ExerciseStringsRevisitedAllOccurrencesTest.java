package chap15_stringsrevisited.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExerciseStringsRevisitedAllOccurrencesTest {

    @Test
    public void canFindAllOccurrencesInStringUsingIndexOf() {
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "l");

        Assert.assertEquals(results.size(), 4);

        Assert.assertEquals(results.contains(2), true);
        Assert.assertEquals(results.contains(3), true);
        Assert.assertEquals(results.contains(8), true);
        Assert.assertEquals(results.contains(9), true);
    }

    @Test
    public void worksWhenNothingToFind() {
        List<Integer> results;
        results = findAllOccurrences("Hello fella", "z");
        Assert.assertEquals(results.size(), 0);

        results = findAllOccurrences("", "z");
        Assert.assertEquals(results.size(), 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void cannotSearchForEmpty() {
        List<Integer> results = findAllOccurrences("", "");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void cannotSearchForNullString() {
        List<Integer> results = findAllOccurrences(null, "hello");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void cannotSearchForNullSubString() {
        List<Integer> results = findAllOccurrences("hello", null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void cannotSearchForNulls() {
        List<Integer> results = findAllOccurrences(null, null);
    }

    private List<Integer> findAllOccurrences(String string, String substring) {
        List<Integer> results = new ArrayList<>();

        if (string == null || substring == null) {
            throw new IllegalArgumentException("Cannot search using null");
        }

        if (substring.isEmpty()) {
            throw new IllegalArgumentException(
                    "Cannot search for Empty substring");
        }

        // set search to the start of the string
        int lastfoundPosition = 0;

        do {
            // try and find the substring
            lastfoundPosition = string.indexOf(substring,
                    lastfoundPosition);

            // if we found it
            if (lastfoundPosition != -1) {

                // add it to the results
                results.add(lastfoundPosition);

                // next start after this index
                lastfoundPosition++;
            }

            // keep looking until we can't find it
        } while (lastfoundPosition != -1);

        return results;
    }
}
