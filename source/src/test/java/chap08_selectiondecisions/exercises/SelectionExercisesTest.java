package chap08_selectiondecisions.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectionExercisesTest {

    @Test
    public void catOrCats() {
        int numberOfCats = 1;

        Assert.assertEquals(
                "cat",
                (numberOfCats == 1) ? "cat" : "cats","1 == cat");

        numberOfCats = 0;
        Assert.assertEquals(
                "cats",
                (numberOfCats == 1) ? "cat" : "cats","0 == cats");

        numberOfCats = 2;
        Assert.assertEquals(
                "cats",
                (numberOfCats == 1) ? "cat" : "cats","2 == cats");
    }

    @Test
    public void catOrCatsAsMethod() {
        Assert.assertEquals( "cat", catOrCats(1),"1 == cat");

        Assert.assertEquals( "cats", catOrCats(0),"0 == cats");

        Assert.assertEquals( "cats", catOrCats(2),"2 == cats");
    }

    private String catOrCats(int numberOfCats) {
        return (numberOfCats == 1) ? "cat" : "cats";
    }

    @Test
    public void truthyIf() {
        boolean truthy = true;

        if (truthy)
            Assert.assertTrue(truthy);

        if (truthy) {
            Assert.assertTrue(truthy);
            Assert.assertFalse(!truthy);
        }
    }

    @Test
    public void truthyIfElse() {
        boolean truthy = true;

        if (truthy)
            Assert.assertTrue(truthy);
        else
            Assert.assertFalse(truthy);
    }

    @Test
    public void truthyIfElseBraces() {
        boolean truthy = true;

        if (truthy) {
            Assert.assertTrue(truthy);
            Assert.assertFalse(!truthy);
        } else {
            Assert.assertFalse(truthy);
        }
    }

    @Test
    public void truthyIfElseOnlyOneSetOfBraces() {
        boolean truthy = true;

        if (truthy) {
            Assert.assertTrue(truthy);
            Assert.assertFalse(!truthy);
        } else
            Assert.assertFalse(truthy);
    }

    @Test
    public void nestedIfElseHorror() {
        horrorOfNestedIfElse(true, true);
        horrorOfNestedIfElse(true, false);
        horrorOfNestedIfElse(false, true);
        horrorOfNestedIfElse(false, false);
    }

    public void horrorOfNestedIfElse(boolean truthy, boolean falsey) {
        if (truthy) {
            if (!falsey) {
                if (truthy && !falsey) {
                    if (falsey || truthy) {
                        System.out.println("T | F");
                        Assert.assertTrue(truthy);
                        Assert.assertFalse(falsey);
                    }
                }
            } else {
                System.out.println("T | T");
                Assert.assertTrue(truthy);
                Assert.assertTrue(falsey);
            }
        } else {
            if (!truthy) {
                if (falsey) {
                    System.out.println("F | T");
                    Assert.assertTrue(falsey);
                    Assert.assertFalse(truthy);
                } else {
                    System.out.println("F | F");
                    Assert.assertFalse(falsey);
                    Assert.assertFalse(truthy);
                }
            }
        }
    }

    @Test
    public void countrySwitch() {
        Assert.assertEquals("United Kingdom", countryOf("UK"));
        Assert.assertEquals("United States", countryOf("US"));
        Assert.assertEquals("United States", countryOf("USA"));
        Assert.assertEquals("United States", countryOf("UsA"));
        Assert.assertEquals("France", countryOf("FR"));
        Assert.assertEquals("Sweden", countryOf("sE"));
        Assert.assertEquals("Rest Of World", countryOf("ES"));
        Assert.assertEquals("Rest Of World", countryOf("CH"));
    }

    private String countryOf(String shortCode) {
        String country;

        switch (shortCode.toUpperCase()) {
            case "UK":
                country = "United Kingdom";
                break;
            case "US":
            case "USA":
                country = "United States";
                break;
            case "FR":
                country = "France";
                break;
            case "SE":
                country = "Sweden";
                break;
            default:
                country = "Rest Of World";
                break;
        }

        return country;
    }

    @Test
    public void integerSwitch() {
        Assert.assertEquals("One", integerString(1));
        Assert.assertEquals("Two", integerString(2));
        Assert.assertEquals("Three", integerString(3));
        Assert.assertEquals("Four", integerString(4));
        Assert.assertEquals("Too big", integerString(5));
        Assert.assertEquals("Too big", integerString(Integer.MAX_VALUE));
        Assert.assertEquals("Too small", integerString(0));
        Assert.assertEquals("Too small", integerString(Integer.MIN_VALUE));
    }

    private String integerString(int anInt) {
        String valReturn = "";

        switch (anInt) {
            case 1:
                valReturn = "One";
                break;
            case 2:
                valReturn = "Two";
                break;
            case 3:
                valReturn = "Three";
                break;
            case 4:
                valReturn = "Four";
                break;
            default:
                if (anInt < 1) {
                    valReturn = "Too small";
                }
                if (anInt > 4) {
                    valReturn = "Too big";
                }
                break;
        }
        return valReturn;
    }


    @Test
    public void integerSwitchReturnOnly() {
        Assert.assertEquals("One", integerStringUsingReturnOnly(1));
        Assert.assertEquals("Two", integerStringUsingReturnOnly(2));
        Assert.assertEquals("Three", integerStringUsingReturnOnly(3));
        Assert.assertEquals("Four", integerStringUsingReturnOnly(4));
        Assert.assertEquals("Too big", integerStringUsingReturnOnly(5));
        Assert.assertEquals("Too big", integerStringUsingReturnOnly(Integer.MAX_VALUE));
        Assert.assertEquals("Too small", integerStringUsingReturnOnly(0));
        Assert.assertEquals("Too small", integerStringUsingReturnOnly(Integer.MIN_VALUE));
    }

    private String integerStringUsingReturnOnly(int anInt) {
        switch (anInt) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            default:
                if (anInt < 1) {
                    return "Too small";
                }
                if (anInt > 4) {
                    return "Too big";
                }
        }
        return "";
    }
}
