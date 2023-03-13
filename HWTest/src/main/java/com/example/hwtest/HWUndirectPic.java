package com.example.hwtest;

import java.util.ArrayList;
import java.util.Scanner;

public class HWUndirectPic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            int side = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Integer>[] lists = new ArrayList[sum + 1];
            for (int i = 0; i < lists.length; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < side; i++) {
                String[] arr = scanner.nextLine().split(" ");
                lists[Integer.parseInt(arr[0])].add(Integer.parseInt(arr[1]));
                lists[Integer.parseInt(arr[1])].add(Integer.parseInt(arr[0]));
            }
            ArrayList<Integer> tokens = new ArrayList<>();
            for (int i = 0; i < sum + 1; i++) {
                tokens.add(0);
            }
            BlackOrRed(lists, sum, 0, tokens);
            System.out.print(num);
            num = 0;
        }
    }

    static int num = 0;

    static void BlackOrRed(ArrayList[] lists, int sum, int ini, ArrayList<Integer> tokens) {
        if (ini == sum) {
            if (Judge(lists, tokens)) {
                num++;
            }
            return;
        }
        tokens.set(ini + 1, 1);//1是红，0是黑
        BlackOrRed(lists, sum, ini + 1, tokens);
        tokens.set(ini + 1, 0);
        BlackOrRed(lists, sum, ini + 1, tokens);

    }

    static boolean Judge(ArrayList<Integer>[] lists, ArrayList<Integer> tokens) {
        for (int i = 1; i < tokens.size(); i++) {
            if (tokens.get(i) == 1) {
                for (int t : lists[i]) {
                    if (tokens.get(t) == 1) return false;
                }
            }
        }
        return true;
    }
}
