package org.example.DTO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class PersonDTO {
    private int age;
    private double salary;
    private String passport;
    private  String address;
    private Date dateOdBirthday;
    private Timestamp dateTimeCreator;
    private Time timeToLunch;
    private String letter;

    public PersonDTO(int age, double salary, String passport, String address, Date dateOdBirthday, Timestamp dateTimeCreator, Time timeToLunch, String letter) {
        this.age = age;
        this.salary = salary;
        this.passport = passport;
        this.address = address;
        this.dateOdBirthday = dateOdBirthday;
        this.dateTimeCreator = dateTimeCreator;
        this.timeToLunch = timeToLunch;
        this.letter = letter;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOdBirthday() {
        return dateOdBirthday;
    }

    public Timestamp getDateTimeCreator() {
        return dateTimeCreator;
    }

    public Time getTimeToLunch() {
        return timeToLunch;
    }

    public String getLetter() {
        return letter;
    }
}
