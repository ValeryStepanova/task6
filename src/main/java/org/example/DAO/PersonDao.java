package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.connecttion.WorkWithBase;

import java.sql.*;

public class PersonDao implements PersonInterfaceDAO {
    public static final String selectAll = "SELECT *from Person";
    public static final String insert = "insert into person(age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String sort = "select* from person where age>21\n" +
            "order by dateTimeCreate asc";
    public static final String DELETE = "delete from person where id = ?";
    public static final  String UPDATE = "UPDATE person\n" +
            "SET age = ?, salary = ?, passport = ?, address = ?, dateOfBirthday = ?, dateTimeCreate = ?, timeToLunch= ?, letter = ?\n" +
            "WHERE person.id = ?";

    public void read(WorkWithBase connection) throws SQLException {
        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectAll);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(2) + " " + resultSet.getDouble(3)
                    + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getDate(6) + " " +
                    resultSet.getTimestamp(7) + " " + resultSet.getTime(8));
        }
        statement.close();
    }

    public void create(PersonDTO personDTO, WorkWithBase connection) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(insert);
        statement.setInt(1, personDTO.getAge());
        statement.setDouble(2, personDTO.getSalary());
        statement.setString(3, personDTO.getPassport());
        statement.setString(4, personDTO.getAddress());
        statement.setDate(5, personDTO.getDateOdBirthday());
        statement.setTimestamp(6, personDTO.getDateTimeCreator());
        statement.setTime(7, personDTO.getTimeToLunch());
        statement.setString(8, personDTO.getLetter());
        statement.executeUpdate();
        statement.close();
        System.out.println("\nПользователь добавлен!\n");
    }

    public void find_and_sort(WorkWithBase connection) throws SQLException {
        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sort);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(2) + " " + resultSet.getDouble(3)
                    + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getDate(6) + " " +
                    resultSet.getTimestamp(7) + " " + resultSet.getTime(8));
        }
        statement.close();
        System.out.println("Все пользователи, возраст которых больше 21 отсортированы");
    }

    @Override
    public void update(PersonDTO personDTO, WorkWithBase connection, int id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(UPDATE);
        statement.setInt(1, personDTO.getAge());
        statement.setDouble(2, personDTO.getSalary());
        statement.setString(3, personDTO.getPassport());
        statement.setString(4, personDTO.getAddress());
        statement.setDate(5, personDTO.getDateOdBirthday());
        statement.setTimestamp(6, personDTO.getDateTimeCreator());
        statement.setTime(7, personDTO.getTimeToLunch());
        statement.setString(8, personDTO.getLetter());
        statement.setInt(9, id);
        statement.executeUpdate();
        statement.close();
        System.out.println("Изменено");
    }

    @Override
    public void delete(int id, WorkWithBase connection) throws SQLException {
        PreparedStatement preparedStatement = connection.getConnection().prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
