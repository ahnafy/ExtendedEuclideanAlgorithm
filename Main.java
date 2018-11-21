// Lab done by Khondoker Ahnaf Prio and Charles Menne

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter r0: ");
        BigInteger r0 = new BigInteger(sc.nextLine());
        System.out.println("Enter r1: ");
        BigInteger r1 = new BigInteger(sc.nextLine());

        printValues(extendedEuclidean(r0, r1));
    }

    /***
     *
     * @param r0
     * @param r1
     * @return Map<String, BigInteger> containing values returned from extended Euclidean algorithm
     */
    private static Map<String, BigInteger> extendedEuclidean(BigInteger r0, BigInteger r1) {
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

    private static void printValues(Map<String, BigInteger> values) {
        for(Map.Entry<String, BigInteger> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
