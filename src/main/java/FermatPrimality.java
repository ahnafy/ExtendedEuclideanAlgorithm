package src.main.java;// Lab done by Khondoker Ahnaf Prio and Charles Menne

import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class FermatPrimality {

    // We check if the number is prime
    private boolean isPrime(BigInteger n, int iteration) {
        // Go through base case of 1 and 2
        if (n.equals(BigInteger.valueOf(0)) || n.equals(BigInteger.valueOf(1)))
            return false;
        if (n.equals(BigInteger.valueOf(2)))
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        Random rand = new Random();
        for (int i = 0; i < iteration; i++) {
            BigInteger r = BigInteger.valueOf(Math.abs(rand.nextInt()));
            BigInteger a = r.mod(n.subtract(BigInteger.valueOf(1))).add(BigInteger.valueOf(1));
            if (!Objects.equals(modPow(a, n.subtract(BigInteger.valueOf(1)), n), BigInteger.valueOf(1)))
                return false;
        }
        return true;
    }

    private BigInteger modPow(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger res = BigInteger.valueOf(1);
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(b) < 0; i.add(BigInteger.valueOf(1))) {
            res = res.multiply(a);
            res = res.mod(c);
        }
        return res.mod(c);
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("We are running Fermat primality test\n");
        FermatPrimality fp = new FermatPrimality();
        System.out.println("Input number");
        BigInteger num = scan.nextBigInteger();
        System.out.println("\nInput number of k tests");
        int k = scan.nextInt();
        boolean prime = fp.isPrime(num, k);
        if (prime) {
            System.out.println("\n" + num + " is prime!");
        } else {
            System.out.println("\n" + num + " is composite!");
        }
    }


}