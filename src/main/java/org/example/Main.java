package org.example;

import org.example.DAO.PersonDao;
import org.example.DTO.PersonDTO;
import org.example.connecttion.WorkWithBase;
import org.example.metadata.MetaData;


import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        WorkWithBase connection = new WorkWithBase();
        try {
            connection.getConnection();
            System.out.println("Connect!");
            PersonDao personDao = new PersonDao();
            personDao.read(connection);
            personDao.create(new PersonDTO(25, 313.0, "MC342", "Jfdf", Date.valueOf("2003-09-22"), Timestamp.valueOf("2024-05-11 23:00:00"), Time.valueOf("15:00:00"), "FFFFFFFFFFFFFFF"), connection);
            personDao.find_and_sort(connection);
            MetaData metaData = new MetaData();
            metaData.getColumns(connection);
            personDao.update(new PersonDTO(23235, 222.0, "MT43244", "gfdgfdd", Date.valueOf("2003-09-22"), Timestamp.valueOf("2024-05-11 23:00:00"), Time.valueOf("15:00:00"), "fdgfdg"), connection,6);
           // personDao.delete(1, connection);
        } catch (SQLException e) {
            System.out.println("Соединение прервано");
        }
        finally {
            System.out.println("Соединение закрыто");
            connection.close();
        }
    }
}