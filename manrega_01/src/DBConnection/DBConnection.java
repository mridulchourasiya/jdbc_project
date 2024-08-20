package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    public static Connection provideConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/mnrega_db";
        try {
            con = DriverManager.getConnection(url, "root", "Core@1221");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return con;
    }



}
