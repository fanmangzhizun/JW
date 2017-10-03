package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by faithpercious on 2017/10/1.
 */
public class DBhelper {
    private   static  final  String URL="jdbc:mysql://localhost:3306/beautygirls";
    private   static  final  String USER="root";
    private static  final  String PASSWORD="root";
    private   static Connection connection=null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getconnection() throws SQLException {
        if (connection==null){
            connection=DriverManager.getConnection(URL,USER,PASSWORD);
            return connection;
        }
        return connection;
    }
}
