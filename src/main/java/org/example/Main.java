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
            List<PersonDTO> list = personDao.printAll();
            for (PersonDTO person : list
            ) {
                System.out.println(person);
            }
            personDao.create(new PersonDTO(25, 313.0, "MC342", "Jfdf", Date.valueOf("2003-09-22"), Timestamp.valueOf("2024-05-11 23:00:00"), Time.valueOf("15:00:00"), "FFFFFFFFFFFFFFF"));
            System.out.println("\nПользователь добавлен!\n");
            System.out.println("Все пользователи, возраст которых больше 21 отсортированы");
            list = personDao.findAndSort();
            for (PersonDTO person : list
            ) {
                System.out.println(person);
            }
            System.out.println("\nMetaData\n");
            MetaData metaData = new MetaData();
            metaData.viewColumns(connection);
        } catch (SQLException e) {
            System.out.println("Соединение прервано");
        }
    }
}