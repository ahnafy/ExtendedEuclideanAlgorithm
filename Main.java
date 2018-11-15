// Lab done by Khondoker Ahnaf Prio and Charles Menne

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter r0: ");
        BigInteger r0 = new BigInteger(sc.nextLine());
        System.out.println("Enter r1: ");
        BigInteger r1 = new BigInteger(sc.nextLine());
        if (r0.compareTo(r1) != 0) {
            System.out.println("Enter a new value for r1 (which has to be less than r0)");
            r1 = new BigInteger(sc.nextLine());



        }



    }
}
