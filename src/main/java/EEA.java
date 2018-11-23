package src.main.java;// Lab done by Khondoker Ahnaf Prio and Charles Menne

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EEA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter r0: ");
        BigInteger r0 = new BigInteger(sc.nextLine());
        System.out.println("Enter r1: ");
        BigInteger r1 = new BigInteger(sc.nextLine());

        printValues(extendedEuclidean(r0, r1));

        // Answers to Q1-4:

        // Q1: gcd(11069529223, 188351587) = x     Answer: x = 105401
        //printValues(extendedEuclidean(BigInteger.valueOf(11069529223L), BigInteger.valueOf(188351587)));

        // Q2: 435985 * S + 288651 * T = 11       Answer: S = 7004, T = -10579
        //printValues(extendedEuclidean(BigInteger.valueOf(435985), BigInteger.valueOf(288651)));

        // Q3: 300 * x ≡ 1 mod 104759        Answer: x = 21301
        //printValues(extendedEuclidean(BigInteger.valueOf(104759), BigInteger.valueOf(300)));

        // Q4: 300 * x ≡ 1 mod 104003        Answer: x = 46108
        //printValues(extendedEuclidean(BigInteger.valueOf(104003), BigInteger.valueOf(300)));
    }

    /***
     *
     * @param r0
     * @param r1
     * @return Map<String, BigInteger> containing values returned from extended Euclidean algorithm
     */
    public static Map<String, BigInteger> extendedEuclidean(BigInteger r0, BigInteger r1) {
        // Storing values returned from extended Euclidean algorithm
        Map<String, BigInteger> euclidValues = new HashMap<>();
        euclidValues.put("r0", r0);
        euclidValues.put("r1", r1);

        // Initializing q, s, and t for algorithm, Last and Holders for intermediary steps
        BigInteger q, s, tLast;
        q = s = tLast = BigInteger.valueOf(0);

        BigInteger t, sLast;
        t = sLast = BigInteger.valueOf(1);

        BigInteger r0Holder, tHolder, sHolder;

        // Start of extended Euclidean algorithm
        // Could have been done recursively, but we decided not to
        while (!r1.equals(BigInteger.valueOf(0))) {

            q = r0.divide(r1);

            r0Holder = r0;
            r0 = r1;
            r1 = r0Holder.mod(r1);

            sHolder = s;
            s = (sLast.subtract(q.multiply(sHolder)));
            sLast = sHolder;

            tHolder = t;
            t = (tLast.subtract(q.multiply(tHolder)));
            tLast = tHolder;
        }

        euclidValues.put("s", sLast);
        euclidValues.put("t", tLast);
        euclidValues.put("gcd", r0);

        return euclidValues;
    }

    // Print out all values from EEA map
    // Includes linear combination of values
    private static void printValues(Map<String, BigInteger> values) {
        for(Map.Entry<String, BigInteger> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();
        System.out.println("Linear combination:");
        System.out.println(values.get("s") + " * " + values.get("r0") + " + " + values.get("t") + " * "
                + values.get("r1") + " = gcd(" + values.get("r0") + ", " + values.get("r1") + ") = " + values.get("gcd"));
    }
}
