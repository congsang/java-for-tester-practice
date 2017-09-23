package chap16_random.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class JavaUtilRandomTest {

    @Test
    public void generateRandomSyntaxExamples() {
        Random generate = new Random();

        boolean randomBoolean = generate.nextBoolean();
        int randomInt = generate.nextInt();
        int randomIntRange = generate.nextInt(12);
        long randomLong = generate.nextLong();
        double randomGaussian = generate.nextGaussian();
        byte[] bytes = new byte[generate.nextInt(100)];
        generate.nextBytes(bytes); // fill byte with random data

        Assert.assertNotNull(generate);
    }

    @Test
    public void generateRandomIntRange() {
        Random generate = new Random();
        int rir;

        rir = generate.nextInt(5);
        Assert.assertEquals(rir >= 0 && rir < 5, true);
        rir = generate.nextInt(200);
        Assert.assertEquals(rir >= 0 && rir < 200, true);
        rir = generate.nextInt(4000);
        Assert.assertEquals(rir >= 0 && rir < 4000, true);
    }

    @Test
    public void generateRandomIntGivenRangeNot0() {
        Random generate = new Random();

        int minValue = 1;
        int maxValue = 5;
        int randomIntRange = generate.nextInt(
                maxValue - minValue + 1) + minValue;

        Assert.assertEquals(randomIntRange <= maxValue, true);
        Assert.assertEquals(randomIntRange >= minValue, true);
    }

    @Test
    public void canGenerateAgeUsingDeviation() {
        Random generate = new Random();

        int age = (int) (generate.nextGaussian() * 5) + 35;
        System.out.println(age);
        if (age < 15)
            age = 15;

        if (age > 55)
            age = 55;

        // dangerous assertions as the test might fail,
        // hence the max and min above
        Assert.assertTrue(age > 14);
        Assert.assertTrue(age < 56);
    }

    @Test
    public void canGenerateRandomNumbersWithSeedExample() {
        Random generate = new Random(1234567L);
        Assert.assertEquals(generate.nextInt(), 1042961893);
    }

    @Test
    public void canSeedWithCurrentDateTime() {
        long currentSeed = System.currentTimeMillis();
        System.out.println("seed used: " + currentSeed);
        Random generate = new Random(currentSeed);

        int prevInt = generate.nextInt();
        System.out.println(generate.nextInt());

        Random generateAgain = new Random(currentSeed);
        Assert.assertEquals(generateAgain.nextInt(), prevInt);
    }

    @Test
    public void generateARandomCharExample(){
        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

        Random random = new Random();

        int rndIndex = random.nextInt(validValues.length());
        char rChar = validValues.charAt(rndIndex);

        if(rChar!=' '){
            Assert.assertTrue(rChar>='A');
            Assert.assertTrue(rChar<='Z');
        }
    }
}
