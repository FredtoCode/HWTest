package com.example.hwtest;

import java.math.BigInteger;
import java.util.Scanner;

public class HWMath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()) {
            double num = input.nextDouble();
            double x = 1.0;
            for (; Math.abs(Math.pow(x, 3) - num) > 1e-5; x = x - (Math.pow(x, 3) - num) / (3 * Math.pow(x, 2)));
            System.out.println(String.format("%.1f", x));
        }
    }
}
