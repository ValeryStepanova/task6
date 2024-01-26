package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.connecttion.WorkWithBase;

import java.sql.*;

public class PersonDao {
    public static final String selectAll = "SELECT *from Person";
    public static final String insert = "insert into person(age, salary, passport, address, dateOfBirthday, dateTimeCreate, timeToLunch, letter)\n" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String sort = "select* from person where age>21\n" +
            "order by dateTimeCreate asc";
    private final WorkWithBase connection = new WorkWithBase();

    public void printAll(WorkWithBase connection) throws SQLException {
        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectAll);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(2) + " " + resultSet.getDouble(3)
                    + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getDate(6) + " " +
                    resultSet.getTimestamp(7) + " " + resultSet.getTime(8));
        }
        statement.close();
    }

    public void create(PersonDTO personDTO) throws SQLException {
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
    }

    public void find_and_sort() throws SQLException {
        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sort);
        while (resultSet.next()){
            System.out.println(resultSet.getInt(2) + " " + resultSet.getDouble(3)
                    + " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getDate(6) + " " +
                    resultSet.getTimestamp(7) + " " + resultSet.getTime(8));
        }
        statement.close();
    }

}
