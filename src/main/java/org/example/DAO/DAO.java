package org.example.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T>{
    void create(T obj) throws SQLException ;
    void update(T obj, int id) throws SQLException;
    List<T> read() throws SQLException;
    void delete(int id) throws SQLException;
}
