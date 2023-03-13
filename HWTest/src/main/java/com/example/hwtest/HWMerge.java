package com.example.hwtest;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HWMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] arrs = scanner.nextLine().split(" ");
            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<String> list = new ArrayList<>();
            String endexport = "";
            for (String coor : arrs) {
                String[] arr = coor.split(",");
                int x = Integer.parseInt(arr[0]);
                int y = Integer.parseInt(arr[1]);
                if (!map.containsKey(x)) {
                    map.put(x, y);
                } else {
                    if (map.get(x) < y) {
                        map.put(x, y);
                    }
                }
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String s, String t1) {
                    return s.compareTo(t1);
                }
            });
            Iterator<Map.Entry<Integer, Integer>> iterator = null;
            GetMap(iterator, map);
            int mapsize = map.size();
            for (int i = 0; i < mapsize; i++) {
                Map.Entry<Integer, Integer> sign = null;
                for (Map.Entry<Integer, Integer> fin : map.entrySet()) {
                    if (sign == null) {
                        sign = fin;
                    } else {
                        if (sign.getKey() > fin.getKey()) {
                            sign = fin;
                        }
                    }
                }
//                assert sign != null;
                map.remove(sign.getKey());
                String member = sign.getKey() + "," + sign.getValue() + " ";
                endexport += member;
                sign = null;
            }
            System.out.println(endexport.trim());
        }
    }

    static void GetMap(Iterator<Map.Entry<Integer, Integer>> iterator, HashMap<Integer, Integer> map){
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            HashMap<Integer, Integer> temporary = new HashMap<>();
            temporary.putAll(map);
            for (Map.Entry<Integer, Integer> entrySub : temporary.entrySet()) {
                if (entry.getValue() >= entrySub.getKey() && entry.getKey() < entrySub.getKey()) {
                    map.remove(entrySub.getKey());
                    if (entry.getValue() < entrySub.getValue()) {
                        entry.setValue(entrySub.getValue());
                    }
                    GetMap(iterator, map);
                    return;
                }
            }
        }
    }
}
