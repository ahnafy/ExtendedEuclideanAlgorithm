package src.test;

import org.junit.*;
import src.main.java.FermatPrimality;

import java.math.BigInteger;
import java.util.Random;

public class FermatPrimalityTest {
    @Test
    public void primeTesting(){
        BigInteger largePrime = BigInteger.probablePrime(512, new Random());
        Assert.assertEquals(FermatPrimality.isPrime(largePrime, 20), true);

        BigInteger largePrime2 = BigInteger.probablePrime(1024, new Random());
        Assert.assertEquals(FermatPrimality.isPrime(largePrime2, 20), true);
    }

    @Test
    public void compositeTesting(){
        BigInteger largeComposite = (BigInteger.probablePrime(512, new Random()).multiply(BigInteger.probablePrime(512, new Random())));
        Assert.assertEquals(FermatPrimality.isPrime(largeComposite, 20), false);

        BigInteger largeComposite2 = (BigInteger.probablePrime(1024, new Random()).multiply(BigInteger.probablePrime(1024, new Random())));
        Assert.assertEquals(FermatPrimality.isPrime(largeComposite2, 20), false);

    }
}
