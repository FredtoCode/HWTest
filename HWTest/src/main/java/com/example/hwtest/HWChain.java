package com.example.hwtest;

import java.util.ArrayList;
import java.util.Scanner;

public class HWChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr1 = StringToInt(scanner.nextLine().split(" "));
            int[] arr2 = StringToInt(scanner.nextLine().split(" "));
            int upordowm = 0;
            if (arr1.length >= 2) {
                upordowm = arr1[1] - arr1[0];
            } else if (arr2.length >= 2) {
                upordowm = arr2[1] - arr2[0];
            }
            Chain header = new Chain(arr1[0], null);
            Chain temporary = header;
            for (int i = 1; i < arr1.length; i++) {
                Chain part = new Chain(arr1[i], null);
                temporary.son = part;
                temporary = part;
            }
            temporary = header;
            for (int i = 0; i < arr2.length; i++) {
                Chain part = new Chain(arr2[i], null);
                if (upordowm >= 0){
//                    for (){
//
//                    }
                }else {

                }
            }

        }
    }

    public static int[] StringToInt(String[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        return array;
    }


    static class Chain {
        int value;
        Chain son;

        public Chain(int value, Chain son) {
            this.value = value;
            this.son = son;
        }

        public Chain() {

        }
    }
}
