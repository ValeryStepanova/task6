package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.connecttion.WorkWithBase;

import java.sql.SQLException;

public interface DAO {
    void create(PersonDTO personDTO, WorkWithBase connection) throws SQLException ;
    void update(PersonDTO personDTO,  WorkWithBase connection, int id) throws SQLException;
    void read(WorkWithBase connection) throws SQLException;
    void delete(int id, WorkWithBase connection) throws SQLException;
}
