package com.example.hwtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HWReOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split(" ");
            ArrayList<String> list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                char[] stc = arr[i].toCharArray();
                Arrays.sort(stc);
                arr[i] = String.valueOf(stc);
            }
            for (String s : arr) {
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }
            int size = map.size();
            for (int i = 0; i < size; i++) {
                Map.Entry<String, Integer> initentry = null;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (initentry == null) {
                        initentry = entry;
                    } else {
                        if (initentry.getValue() < entry.getValue()) {//比次数
                            initentry = entry;
                        } else if (initentry.getValue() == entry.getValue()) {//次数相同
                            if (initentry.getKey().length() > entry.getKey().length()) {//比长度
                                initentry = entry;
                            } else if (initentry.getKey().length() == entry.getKey().length()) {//长度相同
                                initentry = UpOrder(initentry, entry);//字典升序
                            }
                        }
                    }
                }
                map.remove(initentry.getKey());
                list.add(initentry.getKey());
            }
            for (String s : list) {
                System.out.print(s + " ");
            }
        }
    }

    static Map.Entry<String, Integer> UpOrder(Map.Entry<String, Integer> up1, Map.Entry<String, Integer> up2) {
        String[] ss = new String[]{up1.getKey(), up2.getKey()};
        Arrays.sort(ss);
        if (ss[0].equals(up1.getKey())) {
            return up1;
        } else {
            return up2;
        }
    }
}
