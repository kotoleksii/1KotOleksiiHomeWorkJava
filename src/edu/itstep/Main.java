package edu.itstep;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the square array: ");

        int n = sc.nextInt();
        int m = n;
        int c = 0;

        System.out.println("Your array " + n + "x" + m + ":");

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c++;
                if (i % 2 == 0) {
                    a[i][j] = c;
                } else {
                    a[i][m - j - 1] = c;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] % 10 == a[i][j]) {
                    System.out.print("\t");
                } else if (a[i][j] % 100 == a[i][j]) {
                    System.out.print("\t");
                } else if (a[i][j] % 1000 == a[i][j]) {
                    System.out.print("\t");
                }
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
