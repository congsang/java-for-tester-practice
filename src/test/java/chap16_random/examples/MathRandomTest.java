package chap16_random.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathRandomTest {

    @Test
    public void canUseRandomMethodOnMath(){
        double rnd = Math.random();

        System.out.println(
                String.format(
                        "generated %f as random number", rnd));

        Assert.assertEquals(rnd < 1.0d, true);
        Assert.assertEquals(rnd >= 0.0d, true);
    }
}
