package com.example.hwtest;

import java.util.ArrayList;
import java.util.Scanner;

public class MyClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int column = in.nextInt();
        int clounmNum = column;
        int initnum = 0;
        int arr[][] = new int[column][column];
        for (int i = 0; i < column; i++) {
            if (i == 0) {
                for (int j = 0; j < clounmNum - i; j++) {
                    initnum += j + 1;
                    arr[i][j] = initnum;
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                System.out.print("\n");
                for (int j = 0; j < clounmNum - i; j++) {
                    arr[i][j] = arr[i - 1][j + 1] - 1;
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}