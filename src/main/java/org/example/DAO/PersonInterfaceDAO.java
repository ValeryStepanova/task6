package org.example.DAO;

import org.example.connecttion.WorkWithBase;

import java.sql.SQLException;

public interface PersonInterfaceDAO extends DAO {
    void find_and_sort(WorkWithBase connection) throws SQLException;
}
