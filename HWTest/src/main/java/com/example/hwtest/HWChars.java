package com.example.hwtest;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HWChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            ArrayList<Character> list = new ArrayList<>();
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = string.toCharArray();
            for (char c : chars) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            Map.Entry<Character, Integer> sign = null;
            int size = map.size();
            for (int i = 0; i < size; i++) {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (sign == null) {
                        sign = entry;
                    } else {
                        if (sign.getValue() < entry.getValue()) {
                            sign = entry;
                        } else if (sign.getValue().equals(entry.getValue())) {
//                            System.out.print("sign: " + (sign.getKey() - 0) + " entry: " + (entry.getKey() - 0));
                            if ((sign.getKey() - 0) > (entry.getKey() - 0)) {
                                sign = entry;
                            }
                        }
                    }
                }
                list.add(sign.getKey());
                map.remove(sign.getKey());
                sign = null;
            }
            String end = "";
            for (Character part : list) {
                end += part;
            }
            System.out.println(end);
        }
    }
}
