package Bai2;

import java.sql.SQLException;
import java.util.ArrayList;

public  interface INhapThongTin {
    ArrayList<NhanVien> nhapThongTinNhanVien();
    void luuThongTin(ArrayList<NhanVien> listNhanVien) throws SQLException;

    void kiemTraNhanVien()throws SQLException;
    void xoaNhanVien() throws SQLException;
}
