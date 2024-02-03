package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.utils.Printer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public static final String selectAll = "SELECT *from Person";
    public static final String insert = "insert into person(age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String sort = "select* from person where age>21\n" +
            "order by dateTimeCreate asc";
    private final Connection connection;

    public PersonDao(Connection connection) {
        this.connection = connection;
    }


    public List<PersonDTO> printAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectAll);
        List<PersonDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(Printer.build(resultSet));
        }
        statement.close();
        resultSet.close();
        return list;
}

    public void create(PersonDTO personDTO) throws SQLException {
        Printer.setter(personDTO, connection);
    }

    public List<PersonDTO> findAndSort() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sort);
        List<PersonDTO> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(Printer.build(resultSet));
        }
        resultSet.close();
        statement.close();
        return list;
    }

}
