package chap20_mathbigdecimal.exercises;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class MathAndBigDecimalExercisesTest {

    @Test
    public void convinceYourselfOfBigDecimalUsage(){
        try{
            double total = 5 - 0.3 - 0.47 - 1.73;
            System.out.println("2.5 != " + total);
            Assert.assertEquals(total, 2.5);
            Assert.fail("Expected the assert to fail");

        }catch(AssertionError e){}

        int inPennies = 500 - 30 - 47 - 173;
        Assert.assertEquals(inPennies, 250);

        BigDecimal bdTotal = new BigDecimal("5").
                subtract(new BigDecimal("0.30")).
                subtract(new BigDecimal(("0.47"))).
                subtract(new BigDecimal("1.73"));
        Assert.assertEquals(bdTotal, new BigDecimal("2.50"));
    }

    @Test
    public void basicArithmeticWithBigDecimal(){
        BigDecimal bd = BigDecimal.ZERO;
        bd = bd.add(BigDecimal.TEN);
        bd = bd.multiply(BigDecimal.valueOf(2L));
        bd = bd.subtract((BigDecimal.TEN));
        bd = bd.divide(BigDecimal.valueOf(2L));

        Assert.assertEquals(bd, BigDecimal.valueOf(5L));
    }

    @Test
    public void bigDecimalCompareTenAndOne(){
        Assert.assertTrue( BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0);
        Assert.assertTrue( BigDecimal.ONE.compareTo(BigDecimal.TEN) < 0);
        Assert.assertTrue( BigDecimal.TEN.compareTo(BigDecimal.TEN) == 0);
        Assert.assertTrue( BigDecimal.TEN.compareTo(BigDecimal.ONE) != 0);
        Assert.assertTrue( BigDecimal.TEN.compareTo(BigDecimal.ONE) >= 0);
        Assert.assertTrue( BigDecimal.TEN.compareTo(BigDecimal.TEN) >= 0 );
        Assert.assertTrue( BigDecimal.TEN.compareTo(BigDecimal.TEN) <= 0);
        Assert.assertTrue( BigDecimal.ONE.compareTo(BigDecimal.TEN) <= 0);
    }
}
