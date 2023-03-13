package com.example.hwtest;

import java.math.BigInteger;
import java.util.Scanner;

public class HWClimb2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int rank = scanner.nextInt();
            int numT = rank / 2;
            int numO = 0;
            int numS = 0;
            BigInteger end = new BigInteger(String.valueOf(1));
            for (int i = 1; i <= numT; i++) {
                numO = rank - i * 2;
                numS = numO + i;
                BigInteger fm = new BigInteger(String.valueOf(numS));
                BigInteger fz = new BigInteger(String.valueOf(1));
                for (int j = 1; j < i; j++) {
                    fm = fm.multiply(new BigInteger(String.valueOf(numS - j)));
                    fz = fz.multiply(new BigInteger(String.valueOf(j + 1)));
                }
                end = end.add(fm.divide(fz));
            }
            System.out.println(end);
        }
    }
}
