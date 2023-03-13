package com.example.hwtest;

import java.util.LinkedList;
import java.util.Scanner;

public class HWSearch2 {//DFS

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Point> path = new LinkedList<Point>();
        while (scanner.hasNextInt()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] grid = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            dfs(path, 0, 0, grid);
        }

    }
    public static int num = 0;
    static void dfs(LinkedList<Point> path, int x, int y, int[][] grid) {
        path.add(new Point(x, y));
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            num += 1;
            System.out.println("路径" + num + ":");
            for (Point point : path) {
                System.out.println("(" + point.x + "," + point.y + ")");
            }
        }
        if (x + 1 < grid.length && grid[x + 1][y] == 0) {
            grid[x][y] = 1;
            dfs(path, x + 1, y, grid);
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] == 0) {
            grid[x][y] = 1;
            dfs(path, x, y + 1, grid);
        }
        if (x - 1 >= 0 && grid[x - 1][y] == 0) {
            grid[x][y] = 1;
            dfs(path, x - 1, y, grid);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == 0) {
            grid[x][y] = 1;
            dfs(path, x, y - 1, grid);
        }
        path.remove(path.size()-1);
        grid[x][y] = 0;

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}