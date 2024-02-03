package org.example.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaData {
    public void viewColumns(Connection connection) throws SQLException {
        DatabaseMetaData data = connection.getMetaData();
        ResultSet resultSet = data.getColumns(null, null, "person", null);
        while (resultSet.next()){
            System.out.println(resultSet.getString("COLUMN_NAME"));
            System.out.println(resultSet.getString("TYPE_NAME"));
            System.out.println(resultSet.getString("COLUMN_SIZE"));
        }
        resultSet.close();
    }
}
