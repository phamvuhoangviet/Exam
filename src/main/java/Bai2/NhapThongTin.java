package Bai2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class  NhapThongTin implements INhapThongTin {
    Scanner sc = new Scanner(System.in);
    NhanVien nv = new NhanVien();

    public ArrayList<NhanVien> nhapThongTinNhanVien() {
        int stopFlag = 1;
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        while (stopFlag == 1) {
            NhanVien nv = new NhanVien();
            System.out.println("Vui long nhap ID nhan vien: ");
            nv.setIdNhanVien(sc.nextLine());
            System.out.println("Vui long nhap ten nhan vien: ");
            nv.setTenNhanVien(sc.nextLine());
            listNhanVien.add(nv);
            System.out.println("Nhap 1 de tiep tuc them nhan vien moi - Nhap -1 de ket thuc ");
            stopFlag = sc.nextInt();
            sc.nextLine();
        }

        return listNhanVien;
    }

    public void luuThongTin(ArrayList<NhanVien> listNhanVien) throws SQLException {
        for (int i = 0; i < listNhanVien.size(); i++) {
            // Lấy ra đối tượng Connection kết nối vào DB.
            Connection connection = KetNoiSQL.getSQLServerConnection(KetNoiSQL.getDbUrl(), KetNoiSQL.getUserName(), KetNoiSQL.getPASSWORD());
            // Tạo đối tượng Statement.
            Statement conn = connection.createStatement();
            //Statement conn = connection.createStatement("SELECT INTO #LIST_NHAN_VIEN").executeUpdate();
            String sql = "INSERT INTO LIST_NHAN_VIEN VALUES(" + "'" + listNhanVien.get(i).getIdNhanVien() + "'" + ","
                    + "'" + listNhanVien.get(i).getTenNhanVien() + "'" + ");";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            conn.executeUpdate(sql);
        }
    }

    public void kiemTraNhanVien() throws SQLException {
        Connection connection = KetNoiSQL.getSQLServerConnection(KetNoiSQL.getDbUrl(), KetNoiSQL.getUserName(), KetNoiSQL.getPASSWORD());
        Statement conn = connection.createStatement();
        ResultSet rs = conn.executeQuery("select * from LIST_NHAN_VIEN");
        String a;
        System.out.println("Vui long nhap ID nhan vien can kiem tra: ");
        a = sc.nextLine();
        while (rs.next()) {
            String b= rs.getString("ID_NHAN_VIEN").trim();
            if (a.equals(b)) {
                System.out.println(rs.getString("TEN_NHAN_VIEN"));
            }
        }
    }

    public void xoaNhanVien() throws SQLException {
        Connection connection = KetNoiSQL.getSQLServerConnection(KetNoiSQL.getDbUrl(), KetNoiSQL.getUserName(), KetNoiSQL.getPASSWORD());
        Statement conn = connection.createStatement();
        ResultSet rs = conn.executeQuery("select * from LIST_NHAN_VIEN");
        String a;
        System.out.println("Vui long nhap ID nhan vien can kiem tra: ");
        a = sc.nextLine();
        while (rs.next()) {
            String b= rs.getString("ID_NHAN_VIEN").trim();
            if (a.equals(b)) {
            conn.executeUpdate("DELETE LIST_NHAN_VIEN WHERE ID_NHAN_VIEN = '"+b+"'");
            }
        }
        //rs.close();
    }
}



