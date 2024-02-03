package org.example;

import org.example.DAO.PersonDao;
import org.example.DTO.PersonDTO;
import org.example.connecttion.WorkWithBase;
import org.example.metadata.MetaData;


import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(WorkWithBase.getURL(), WorkWithBase.getUser(), WorkWithBase.getPassword())) {
            System.out.println("Connect!");
            PersonDao personDao = new PersonDao(connection);
            System.out.println("Все пользователи: ");
            List<PersonDTO> list = personDao.read();
            for (PersonDTO person : list
            ) {
                System.out.println(person);
            }
            personDao.create(new PersonDTO(25, 313.0, "MC342", "Jfdf", Date.valueOf("2003-09-22"), Timestamp.valueOf("2024-05-11 23:00:00"), Time.valueOf("15:00:00"), "FFFFFFFFFFFFFFF"));
            list = personDao.findAndSort();
            for (PersonDTO person : list
            ) {
                System.out.println(person);
            }
            MetaData metaData = new MetaData();
            metaData.getColumns(connection);
            personDao.update(new PersonDTO(23235, 222.0, "MT43244", "gfdgfdd", Date.valueOf("2003-09-22"), Timestamp.valueOf("2024-05-11 23:00:00"), Time.valueOf("15:00:00"), "fdgfdg"), 2);
            personDao.delete(2);
        } catch (SQLException e) {
            System.out.println("Соединение прервано");
        }

    }
}