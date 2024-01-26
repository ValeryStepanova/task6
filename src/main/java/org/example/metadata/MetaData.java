package org.example.metadata;

import org.example.connecttion.WorkWithBase;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MetaData {
    public void getColumns(WorkWithBase connection) throws SQLException {
        System.out.println("\nMetaData\n");
        DatabaseMetaData data = connection.getConnection().getMetaData();
        ResultSet resultSet = data.getColumns(null, null, "person", null);
        while (resultSet.next()){
            System.out.println(resultSet.getString("COLUMN_NAME") + " "
                    + resultSet.getString("TYPE_NAME") + " "
                    + resultSet.getString("COLUMN_SIZE"));
        }
    }
}
