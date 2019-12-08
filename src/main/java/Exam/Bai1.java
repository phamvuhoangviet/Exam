package Exam;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui long nhap gia tri a: ");
        a = sc.nextInt();
        System.out.println("Vui long nhap gia tri b: ");
        b = sc.nextInt();
        int[][] mang2chieu = new int[a][b];
        for (int i = 0; i < a ; i++) {
            for (int j = 0; j < b ; j++) {
                System.out.println("Gia tri thu " + i + "," + j + " cua mang: ");
                mang2chieu[i][j] = i*j;
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(mang2chieu[i][j]+ ",");
            }
        }
    }
}
