package org.example.connecttion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkWithBase {
    private static final String url = "jdbc:mysql://localhost:3306/Person";
    private static final String user = "root";
    private static final String password = "Dvnesp1350";

   private Connection connection;

   public synchronized  Connection getConnection() throws SQLException {
       if(connection==null){
         connection = DriverManager.getConnection(url, user, password);
       }
       return connection;
   }

   public synchronized void close() throws SQLException {
       if(!connection.isClosed()){
           connection.close();
       }
   }
}
