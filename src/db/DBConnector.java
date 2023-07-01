package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static DBConnector dbConnector;
    private Connection connection;

    private DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pjd","root","1234");
    }

    public static DBConnector getInstance() throws SQLException, ClassNotFoundException {
        return dbConnector == null ? dbConnector=new DBConnector() : dbConnector;
    }

    public Connection getConnection(){
        return connection;
    }
}
