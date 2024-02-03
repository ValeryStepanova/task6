package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.utils.Printer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements PersonInterfaceDAO {
    public static final String selectAll = "SELECT *from Person";
    public static final String insert = "insert into person(age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String sort = "select* from person where age>21\n" +
            "order by dateTimeCreate asc";
    public static final String DELETE = "delete from person where id = ?";
    public static final String UPDATE = "UPDATE person\n" +
            "SET age = ?, salary = ?, passport = ?, address = ?, dateOfBirthday = ?, dateTimeCreate = ?, timeToLunch= ?, letter = ?\n" +
            "WHERE person.id = ?";
    Connection connection;


    public PersonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(PersonDTO personDTO) throws SQLException {
        Printer.setter(personDTO,connection, insert, 0);
        System.out.println("Пользователь добавлен");
    }

    public List<PersonDTO> read() throws SQLException {
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

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("Удалено");
    }

    @Override
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

    @Override
    public void update(PersonDTO personDTO, int id) throws SQLException {
        Printer.setter(personDTO, connection, UPDATE, id);
        System.out.println("Пользовател изменен");

    }
}
