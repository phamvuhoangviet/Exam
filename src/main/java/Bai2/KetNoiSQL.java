package Bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KetNoiSQL {
    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=EXAM_NHAN_VIEN;" +
            "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "1234567890";

//        public static void main(String args[]) {
//            try {
//                // connnect to database ''
//                Connection conn = getSQLServerConnection(DB_URL, USER_NAME, PASSWORD);
//                // create statement
//                Statement stmt = conn.createStatement();
//                // get data from table 'EMPLOYEE'
//                ResultSet rs = stmt.executeQuery("select * from EMPLOYEE");
//                // show data
//                while (rs.next()) {
//                    System.out.println(rs.getString(1) + " " +
//                            rs.getString(2) + " " +
//                            rs.getDate(3)   + " " +
//                            rs.getString(4) + " " +
//                            rs.getString(5) + " " +
//                            rs.getString(6));
//                }
//                // close connection
//                conn.close();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }


    /**
     * create connection
     *
     * @param dbURL: database's url
     * @param userName: username is used to login
     * @param password: password is used to login
     * @return connection
     */
    public static Connection getSQLServerConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Ket noi thanh cong!");
        } catch (Exception ex) {
            System.out.println("Ket noi that bai!");
            ex.printStackTrace();
        }
        return conn;
    }
}