package org.example.DAO;

import org.example.DTO.PersonDTO;

import java.util.List;

public interface DAOPerson extends DAO<PersonDTO> {
    List<PersonDTO> findAndSort();
}
