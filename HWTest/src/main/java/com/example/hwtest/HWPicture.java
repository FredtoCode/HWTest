package com.example.hwtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HWPicture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Integer>[] arrayLists = new ArrayList[sum + 1];
            for (int i = 1; i < arrayLists.length; i++) {
                arrayLists[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < sum - 1; i++) {
                String[] point = scanner.nextLine().split(" ");
                arrayLists[Integer.parseInt(point[0])].add(Integer.parseInt(point[1]));
            }
            Queue<Point> queue = new LinkedList<>();
            for (int ini : arrayLists[1]) {
                Point point = new Point(1, ini, 1);
                queue.offer(point);
            }
            Point sign = new Point();
            while (!queue.isEmpty()) {
                sign = queue.poll();
                assert sign != null;
                if (arrayLists[sign.y].size() > 0) {
                    for (int ini : arrayLists[sign.y]) {
                        queue.offer(new Point(sign.y, ini, sign.step + 1));
                    }
                }
            }
            System.out.println(2*(sum - 1) - sign.step);
        }
    }

    static class Point {
        int x;
        int y;
        int step;

        public Point() {

        }

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

}
