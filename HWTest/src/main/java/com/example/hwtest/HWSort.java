package com.example.hwtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HWSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listI = new ArrayList<>();
        ArrayList<String> listR = new ArrayList<>();
        ArrayList<String> listFinal = new ArrayList<>();
        listFinal.add("0");
        ArrayList<String> listTemporary = new ArrayList<>();
        String[] arrI = scanner.nextLine().split(" ");//i
        String[] arrR = scanner.nextLine().split(" ");//R
        String[] arrRnew = new String[arrR.length - 1];//xR
        for (int i = 1; i < arrI.length; i++) {
            listI.add(arrI[i]);
        }
        for (int i = 1; i < arrR.length; i++) {
            arrRnew[i - 1] = arrR[i];
        }
        int[] arrRInt = StringToInt(arrRnew);
        Arrays.sort(arrRInt);//排序R
        arrRnew = IntToString(arrRInt);
        for (int i = 0; i < arrRnew.length; i++) {//去重R
            if (!listR.contains(arrRnew[i]))
                listR.add(arrRnew[i]);
        }
        for (int R = 0; R < listR.size(); R++) {
            int num = 0;
            for (int I = 0; I < listI.size(); I++) {
                if (listI.get(I).contains(listR.get(R))) {
                    num += 1;
                    listTemporary.add(String.valueOf(I));
                    listTemporary.add(listI.get(I));
                }
            }
            if (num != 0) {
                listFinal.add(listR.get(R));
                listFinal.add(String.valueOf(num));
                listFinal.addAll(listTemporary);
                listTemporary.clear();
            }
        }
        listFinal.set(0, String.valueOf(listFinal.size() - 1));
        for (String F : listFinal) {
            System.out.print(F + " ");
        }
    }

    public static int[] StringToInt(String[] arr) {
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        return array;
    }

    public static String[] IntToString(int[] arr) {
        String[] array = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = String.valueOf(arr[i]);
        }
        return array;
    }

}
