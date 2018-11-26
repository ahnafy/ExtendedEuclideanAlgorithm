package src.main.java;
import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class MillerRabin {

    // Check if a number is prime
    private boolean isPrime(BigInteger n, int iteration) {
        // base case of 1 and 2 since they are prime
        if (n.equals(BigInteger.valueOf(0)) || n.equals(BigInteger.valueOf(1)))
            return false;
        if (n.equals(BigInteger.valueOf(2)))
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        BigInteger s = n.subtract(BigInteger.valueOf(1));
        while (s.mod(BigInteger.valueOf(2)) == BigInteger.valueOf(0)) {
            s = s.divide(BigInteger.valueOf(2));
        }

        Random rand = new Random();
        for (int i = 0; i < iteration; i++) {
            BigInteger r = BigInteger.valueOf(Math.abs(rand.nextInt()));
            BigInteger a = r.mod((n.subtract(BigInteger.valueOf(1))).add(BigInteger.valueOf(1))), temp = s;
            BigInteger mod = modPow(a, temp, n);
            while (temp != n.subtract(BigInteger.valueOf(1)) && !mod.equals(BigInteger.valueOf(1)) && !mod.equals(n.subtract(BigInteger.valueOf(1)))) {
                mod = mulMod(mod, mod, n);
                temp = temp.multiply(BigInteger.valueOf(2));
            }
            if (!mod.equals(n.subtract(BigInteger.valueOf(1))) && temp.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                return false;
            }
        }
        return true;
    }

    // Calculate large power of a large number mod-ing a large number
    private BigInteger modPow(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger res = BigInteger.valueOf(1);
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(b) < 0; i.add(BigInteger.valueOf(1))) {
            res = res.multiply(a);
            res = res.mod(c);
        }
        return res.mod(c);
    }

    // Calculate multiplication of two large numbers mod a large number
    private BigInteger mulMod(BigInteger a, BigInteger b, BigInteger mod) {
        return a.multiply(b).mod(mod);
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("We are running the Miller Rabin test\n");
        MillerRabin mr = new MillerRabin();
        System.out.println("Input Number!");
        BigInteger num = scan.nextBigInteger();
        System.out.println("\nInput number of k tests");
        int k = scan.nextInt();
        boolean prime = mr.isPrime(num, k);
        if (prime) {
            System.out.println("\n" + num + " is prime!");
        } else {
            System.out.println("\n" + num + " is composite!");
        }

    }
}