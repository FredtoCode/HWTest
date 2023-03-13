package com.example.hwtest;

import java.util.Calendar;
import java.util.Scanner;

public class HWString {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            StringBuilder endString = new StringBuilder();
//            System.out.print("输入为：");
            String string = scanner.next();
            for (int i = 0; i < string.length(); i++) {
                char index = string.charAt(i);
                if (Character.isDigit(index)) {
                    if (i == 0) {
                        endString.append("*");
                    }
                    if ((i == string.length() - 1) || !Character.isDigit(string.charAt(i + 1))) {
                        endString.append(index).append("*");
                    } else {
                        endString.append(index);
                    }
                } else {
                    if (i == string.length() - 1) {
                        endString.append(index);
                    } else if (Character.isDigit(string.charAt(i + 1))) {
                        endString.append(index).append("*");
                    } else {
                        endString.append(index);
                    }
                }
            }
            System.out.print(endString);
        } catch (Exception e) {
            System.out.print("异常：" + e);
        }
    }
}
