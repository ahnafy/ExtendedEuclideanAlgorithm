package src.test;

import org.junit.*;
import src.main.java.EEA;

import java.math.BigInteger;
import java.util.Map;

public class EEATest {
    @Test
    public void smallEEATest(){
        Map<String, BigInteger> values = EEA.extendedEuclidean(BigInteger.valueOf(99), BigInteger.valueOf(16));

        // Asserting that extended Euclidean algorithm with r0=99, r1=16
        // has a gcd of 1, s = -5, t = 31
        Assert.assertEquals(values.get("gcd"), BigInteger.valueOf(1));
        Assert.assertEquals(values.get("s"), BigInteger.valueOf(-5));
        Assert.assertEquals(values.get("t"), BigInteger.valueOf(31));

        // Setting values to EEA with r0=500, r1=77
        values = EEA.extendedEuclidean(BigInteger.valueOf(500), BigInteger.valueOf(77));

        // Asserting that extended Euclidean algorithm with r0=500, r1=77
        // has a gcd of 1, s = -2, t = 13
        Assert.assertEquals(values.get("gcd"), BigInteger.valueOf(1));
        Assert.assertEquals(values.get("s"), BigInteger.valueOf(-2));
        Assert.assertEquals(values.get("t"), BigInteger.valueOf(13));
    }
}
