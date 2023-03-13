package com.example.hwtest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        int num = scanner.nextInt();//573147844013817084101
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("2");
        for (int i = 0; i < (num - 2)/2; i++) {
            a = a.add(b);
            b = b.add(a);
        }
        System.out.print("输出：" + b);
    }
}
