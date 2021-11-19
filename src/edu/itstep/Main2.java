package edu.itstep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        int n, m, k = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        n = sc.nextInt();
        System.out.print("Enter the number of seats: ");
        m = sc.nextInt();

        int[][] a = new int[n][m];

        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = rnd.nextInt(2);
                System.out.print("\t" + a[i][j]);
            }
            System.out.println();
        }

        System.out.print("How many tickets do you need in the neighborhood?");
        k = sc.nextInt();

        List<Integer[]> free = new ArrayList<>();

        for (int i = 0; i < a.length; ++i) {
            for (int j = 0, count = 0; j < a[i].length; ++j) {
                if (k == 1 && a[i][j] == 0) {
                    Integer[] curr = {i + 1, j + 1};
                    free.add(curr);
                } else if (j > 0 && a[i][j] == 0 && a[i][j] == a[i][j - 1]) {
                    ++count;
                    if (count == k - 1) {
                        for (int l = k - 1; l >= 0; --l) {
                            Integer[] curr = {i + 1, j - l + 1};
                            free.add(curr);
                        }
                        count = 0;
                    }
                } else {
                    count = 0;
                }
            }
        }

        if (free.isEmpty())
            System.out.println("Sorry, no tickets available :(");

        for (Integer[] s : free) {
            System.out.println("In the " + s[0] + " row" + " free " + s[1] + " seat");
        }
    }
}
