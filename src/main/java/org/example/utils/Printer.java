package org.example.utils;

import org.example.DTO.PersonDTO;
import java.sql.*;
import static org.example.DAO.PersonDao.insert;

public class Printer {
   public static void setter(PersonDTO personDTO, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(insert);
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
    public static PersonDTO build(ResultSet resultSet) throws SQLException {
       return PersonDTO.builder()
               .age(resultSet.getInt(2))
               .salary(resultSet.getDouble(3))
               .passport(resultSet.getString(4))
               .address(resultSet.getString(5))
               .dateOdBirthday(resultSet.getDate(6))
               .dateTimeCreator(resultSet.getTimestamp(7))
               .timeToLunch(resultSet.getTime(8))
               .letter(resultSet.getString(9))
               .build();
    }
}
