package org.example.metadata;



import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MetaData {
    public void getColumns(Connection connection) throws SQLException {
        System.out.println("\nMetaData\n");
        DatabaseMetaData data = connection.getMetaData();
        ResultSet resultSet = data.getColumns(null, null, "person", null);
        while (resultSet.next()){
            System.out.println(resultSet.getString("COLUMN_NAME") + " "
                    + resultSet.getString("TYPE_NAME") + " "
                    + resultSet.getString("COLUMN_SIZE"));
        }
    }
}
