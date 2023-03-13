package com.example.hwtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class HWMaxAbility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            scanner.nextLine();
            int[] map = new int[50001];
            int max = 0;
            int temporary = 0;
            for (int i = 0; i < sum; i++) {
                int[] arr = StringToInt(scanner.nextLine().split(" "));
                map[arr[0]] = map[arr[0]] + arr[2];
                map[arr[1]] = map[arr[1]] - arr[2];
            }
            for (int i = 0; i < map.length; i++) {
                temporary += map[i];
                if(temporary > max){
                    max = temporary;
                }
            }
            System.out.println(max);
        }
    }

    public static int[] StringToInt(String[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        return array;
    }

}
