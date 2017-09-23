package chap20_mathbigdecimal.examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathAndBigDecimalTest {

    @Test(expectedExceptions = AssertionError.class)
    public void whyBigDecimal(){
        // 10 pence + 73 pence = 83 pence
        float total = 0.1f + 0.73f;
        Assert.assertEquals(total, 0.83f);
        // the above assert fails but: was <0.83000004F>
    }

    @Test
    public void usingBigDecimal(){
        BigDecimal bdtotal = new BigDecimal("0.1").add(new BigDecimal("0.73"));
        Assert.assertEquals(bdtotal, new BigDecimal("0.83"));
    }

    @Test
    public void bigDecimalConstructor(){
        BigDecimal fromInt = new BigDecimal(5);
        BigDecimal fromLong = new BigDecimal(5L);
        BigDecimal fromString = new BigDecimal("5");
        BigDecimal fromDouble = new BigDecimal(5.0);
        BigDecimal fromBigInteger = new BigDecimal(BigInteger.valueOf(5L));

        Assert.assertEquals(fromInt, fromLong);
        Assert.assertEquals(fromString, fromDouble);
        Assert.assertEquals(fromBigInteger, fromString);
        Assert.assertEquals(fromLong, fromDouble);
    }

    @Test
    public void bigDecimalStaticMethods(){
        BigDecimal bd0 = BigDecimal.ZERO;
        BigDecimal bd1 = BigDecimal.ONE;
        BigDecimal bd10 = BigDecimal.TEN;
        BigDecimal bdVal = BigDecimal.valueOf(5.0);

        Assert.assertEquals(bd0, new BigDecimal("0"));
        Assert.assertEquals(bd1, new BigDecimal("1"));
        Assert.assertEquals(bd10, BigDecimal.valueOf(10L));
        Assert.assertEquals(bdVal, new BigDecimal("5.0"));

        Assert.assertEquals( BigDecimal.ONE.equals(new BigDecimal(1.0)), true);
        Assert.assertEquals( BigDecimal.ONE.equals(new BigDecimal("1")), true);
    }

    @Test
    public void bigDecimalGreaterThanLessThan(){
        Assert.assertEquals(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0, true);
    }

    @Test
    public void maxTest(){
        Assert.assertEquals( Math.max(23.0, 42.0), 42.0);
    }
}
