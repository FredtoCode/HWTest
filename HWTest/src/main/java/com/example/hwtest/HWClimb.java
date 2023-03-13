package com.example.hwtest;

import java.util.Scanner;

public class HWClimb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int rank = scanner.nextInt();
            dfs(rank, 0);
            System.out.println(number);
            number = 0;
        }
    }

    static int number = 0;

    static void dfs(int rank, int steps) {
        if (steps > rank) {
            return;
        }
        if (steps == rank) {
            number++;
            return;
        }
        dfs(rank, steps + 1);
        dfs(rank, steps + 2);
    }
}
