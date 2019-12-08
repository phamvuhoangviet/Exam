package Bai2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        INhapThongTin inv = new NhapThongTin();
        while (true){
            System.out.println("Vui long chon chuc nang cua chuong trinh: ");
            System.out.println("0. Dung chuong trinh: ");
            System.out.println("1. Nhap thong tin nhan vien: ");
            System.out.println("2. Luu thong tin nhan vien vao CSDL: ");
            System.out.println("3. Truy xuat thong tin nhan vien trong CSDL");
            System.out.println("4. Xoa thong tin nhan vien theo ID trong CSDL");
            int i = sc.nextInt();
            sc.nextLine();
            switch (i){
                case 0:
                    System.exit(1);
                case 1:
                    listNhanVien = inv.nhapThongTinNhanVien();
                    break;
                case 2:
                    inv.luuThongTin(listNhanVien);
                    break;
                case 3:
                    inv.kiemTraNhanVien();
                case 4:
                    inv.xoaNhanVien();
            }
        }

    }
}
