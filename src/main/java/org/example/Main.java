package org.example;

import org.example.DAO.PersonDao;
import org.example.DTO.PersonDTO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        PersonDTO personDTO = PersonDTO.builder()
                .age(43)
                .salary(5432)
                .passport("gfgf")
                .address("gdfd")
                .dateOfBirthday(Date.valueOf("2003-09-22"))
                .dateTimeCreate(new Timestamp(System.currentTimeMillis()))
                .timeToLunch(Time.valueOf("22:33:22"))
                .letter("gfdfg")
                .build();
        personDao.create(personDTO);
        personDTO.setAge(2343);
        System.out.println(personDao.update(personDTO));
        System.out.println(personDao.read(24));
        personDao.delete(35);
        List<PersonDTO> list = personDao.findAndSort();
        list.forEach(System.out::println);

    }
}