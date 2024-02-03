package org.example.DAO;

import org.example.DTO.PersonDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonInterfaceDAO extends DAO<PersonDTO> {
    List<PersonDTO> findAndSort() throws SQLException;
}
