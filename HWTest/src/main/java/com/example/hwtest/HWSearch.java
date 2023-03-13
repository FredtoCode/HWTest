package com.example.hwtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HWSearch {//BFS
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int raw, col;
        while (scanner.hasNextInt()) {
            raw = scanner.nextInt();
            col = scanner.nextInt();
            int[][] grid = new int[raw][col];
            for (int i = 0; i < raw; i++) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            Point pos = new Point(0, 0, null);
            Queue<Point> queue = new LinkedList<Point>();
            queue.offer(pos);
            int num = 0;
            while (!queue.isEmpty()) {
                pos = queue.poll();
                int px = pos.x;
                int py = pos.y;
                if (px == raw - 1 && py == col - 1) {
                    num += 1;
                    System.out.println("路径" + num + ": ");
                    Print(pos);
                }
                if (px + 1 < raw && grid[px + 1][py] == 0) {//下
                    grid[px][py] = 1;
                    queue.offer(new Point(px + 1, py, pos));
                }
                if (py + 1 < col && grid[px][py + 1] == 0) {//右
                    grid[px][py] = 1;
                    queue.offer(new Point(px, py + 1, pos));
                }
                if (px - 1 >= 0 && grid[px - 1][py] == 0) {//上
                    grid[px][py] = 1;
                    queue.offer(new Point(px - 1, py, pos));
                }
                if (py - 1 >= 0 && grid[px][py - 1] == 0) {//左
                    grid[px][py] = 1;
                    queue.offer(new Point(px, py - 1, pos));
                }
            }
            System.out.println("BFS结束......");

        }
    }

    static void Print(Point pos) {
        if (pos.father != null) {
            Print(pos.father);
        }
        System.out.println("(" + pos.x + "," + pos.y + ")");
    }

    static class Point {
        int x;
        int y;
        Point father;

        public Point(int x, int y, Point father) {
            this.x = x;
            this.y = y;
            this.father = father;
        }

        public Point() {

        }
    }
}
