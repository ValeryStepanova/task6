package org.example.DAO;
import org.example.DTO.PersonDTO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class TestUtil {
    public static PersonDTO build(){
        return PersonDTO.builder()
                .age(43)
                .salary(5432)
                .passport("gfgf")
                .address("gdfd")
                .dateOfBirthday(Date.valueOf("2003-09-22"))
                .dateTimeCreate(new Timestamp(System.currentTimeMillis()))
                .timeToLunch(Time.valueOf("22:33:22"))
                .letter("gfdfg")
                .build();
    }
    public static PersonDTO buildPerson21(){
        return PersonDTO.builder()
                .age(20)
                .salary(5432)
                .passport("gfgf")
                .address("gdfd")
                .dateOfBirthday(Date.valueOf("2003-09-22"))
                .dateTimeCreate(new Timestamp(System.currentTimeMillis()))
                .timeToLunch(Time.valueOf("22:33:22"))
                .letter("gfdfg")
                .build();
    }
}
