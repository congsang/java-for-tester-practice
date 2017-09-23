package chap16_random.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class JavaUtilRandomExercisesTest {

    /* Tests which confirm random limits */
    @Test
    public void canGenerateRandomInt() {
        Random generate = new Random();

        for (int x = 0; x < 1000; x++) {

            int randomInt = generate.nextInt();

            System.out.println(randomInt);
            Assert.assertEquals(randomInt < Integer.MAX_VALUE, true);
            Assert.assertEquals(randomInt >= Integer.MIN_VALUE, true);
        }
    }

    @Test
    public void canGenerateRandomBoolean() {
        Random generate = new Random();
        int countTrue = 0;
        int countFalse = 0;

        for (int x = 0; x < 1000; x++) {

            boolean randomBoolean = generate.nextBoolean();

            if (randomBoolean)
                countTrue++;

            if (randomBoolean == false)
                countFalse++;

            System.out.println(randomBoolean);
        }

        System.out.println(
                String.format("Generated %d as true", countTrue));
        System.out.println(
                String.format("Generated %d as false", countFalse));

        Assert.assertEquals(countTrue > 0, true);
        Assert.assertEquals(countFalse > 0, true);
        Assert.assertEquals(countTrue + countFalse, 1000);
    }

    @Test
    public void canGenerateRandomLong() {
        Random generate = new Random();

        for (int x = 0; x < 1000; x++) {
            long randomLong = generate.nextLong();
            System.out.println(randomLong);
            Assert.assertEquals(randomLong < Long.MAX_VALUE, true);
            Assert.assertEquals(randomLong >= Long.MIN_VALUE, true);
        }
    }

    @Test
    public void canGenerateRandomFloat() {
        Random generate = new Random();

        for (int x = 0; x < 1000; x++) {
            float randomFloat = generate.nextFloat();
            System.out.println(randomFloat);
            Assert.assertEquals(randomFloat < 1.0f, true);
            Assert.assertEquals(randomFloat >= 0.0f, true);
        }
    }

    @Test
    public void canGenerateRandomDouble() {
        Random generate = new Random();

        for (int x = 0; x < 1000; x++) {
            double randomDouble = generate.nextDouble();
            System.out.println(randomDouble);
            Assert.assertEquals(randomDouble < 1.0d, true);
            Assert.assertEquals(randomDouble >= 0.0d, true);
        }
    }

    @Test
    public void canGenerateRandomByte() {
        Random generate = new Random();

        for (int x = 0; x < 1000; x++) {
            // randomly generate a byte array between 0 and 99 length
            int arrayLength = generate.nextInt(100);
            byte[] bytes = new byte[arrayLength];
            generate.nextBytes(bytes);  // fill bytes with random data
            Assert.assertEquals(arrayLength, bytes.length);
            String viewbytes = new String(bytes);
            System.out.println(bytes.length + " - " + viewbytes);
        }
    }

    @Test
    public void generateRandomIntGivenRange() {
        Random generate = new Random();

        for (int x = 0; x < 1000; x++) {
            // between 0 (>=) and <(12)
            int randomIntRange = generate.nextInt(12);
            System.out.println(randomIntRange);
            Assert.assertEquals(randomIntRange <= 11, true);
            Assert.assertEquals(randomIntRange >= 0, true);
        }
    }

    @Test
    public void generateRandomIntGivenRangeNot0Exercise() {
        Random generate = new Random();

        Set<Integer> nums = new HashSet<>();

        for (int x = 0; x < 1000; x++) {

            int minValue = 15;
            int maxValue = 20;
            int randomIntRange = generate.nextInt(
                    maxValue - minValue + 1) + minValue;

            nums.add(randomIntRange);
            Assert.assertEquals(randomIntRange <= maxValue, true);
            Assert.assertEquals(randomIntRange >= minValue, true);
        }

        Assert.assertEquals(nums.size(), 6);
        Assert.assertEquals(nums.contains(15), true);
        Assert.assertEquals(nums.contains(16), true);
        Assert.assertEquals(nums.contains(17), true);
        Assert.assertEquals(nums.contains(18), true);
        Assert.assertEquals(nums.contains(19), true);
        Assert.assertEquals(nums.contains(20), true);
    }

    @Test
    public void canGenerateRandomGaussianDistributionDouble() {
        Random generate = new Random();

        int standardDeviationCount1 = 0;
        int standardDeviationCount2 = 0;
        int standardDeviationCount3 = 0;
        int standardDeviationCount4 = 0;

        for (int x = 0; x < 1000; x++) {

            double randomGaussian = generate.nextGaussian();

            //System.out.println(randomValue);
            if (randomGaussian > -1.0d && randomGaussian < 1.0d)
                standardDeviationCount1++;

            if (randomGaussian > -2.0d && randomGaussian < 2.0d)
                standardDeviationCount2++;

            if (randomGaussian > -3.0d && randomGaussian < 3.0d)
                standardDeviationCount3++;

            if (randomGaussian > -4.0d && randomGaussian < 4.0d)
                standardDeviationCount4++;
        }

        float sd1percentage = (standardDeviationCount1 / 1000f) * 100f;
        System.out.println("about 70% one standard deviation = " +
                sd1percentage);

        float sd2percentage = (standardDeviationCount2 / 1000f) * 100f;
        System.out.println("about 95% two standard deviation = " +
                sd2percentage);

        float sd3percentage = (standardDeviationCount3 / 1000f) * 100f;
        System.out.println("about 99% three standard deviation = " +
                sd3percentage);

        float sd4percentage = (standardDeviationCount4 / 1000f) * 100f;
        System.out.println("about 99.9% four standard deviation = " +
                sd4percentage);

        Assert.assertTrue(sd1percentage < sd2percentage);
        Assert.assertTrue(sd2percentage < sd3percentage);
        // I do not assert that sd3 and sd4 are different
        // because of the small % difference, they do overlap
    }

    @Test
    public void canGenerate1000AgesUsingDeviation() {

        Random generate = new Random();
        Map<Integer, Integer> ages =
                new HashMap<>();

        for (int x = 0; x < 1000; x++) {
            int age = (int) (generate.nextGaussian() * 5) + 35;

            int ageCount = 0;
            if (ages.containsKey(age)) {
                ageCount = ages.get(age);
            }
            ageCount++;
            ages.put(age, ageCount);
        }

        SortedSet<Integer> agesSorted = new TreeSet(ages.keySet());

        for (int age : agesSorted) {
            System.out.println(age + " : " + ages.get(age));
        }
    }

    @Test
    public void canGenerateRandomNumbersWithSeed() {

        for (int x = 0; x < 10; x++) {

            Random generate = new Random(1234567L);

            Assert.assertEquals(generate.nextInt(), 1042961893);
            Assert.assertEquals(generate.nextLong(), -6749250865724111202L);
            Assert.assertEquals(generate.nextDouble(), 0.44762832574617084D);
            Assert.assertEquals(generate.nextGaussian(), -0.11571220872310763D);
            Assert.assertEquals(generate.nextFloat(), 0.33144182F);
            Assert.assertEquals(generate.nextBoolean(), false);
        }
    }

    @Test
    public void generateARandomString() {

        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

        StringBuilder rString;

        Random random = new Random();

        rString = new StringBuilder();
        for (int x = 0; x < 100; x++) {
            int rndIndex = random.nextInt(validValues.length());
            char rChar = validValues.charAt(rndIndex);
            rString.append(rChar);
        }

        System.out.println(rString.toString());
        Assert.assertTrue(rString.length() == 100);
        Assert.assertTrue(rString.toString().matches("[A-Z ]+"));
    }
}
