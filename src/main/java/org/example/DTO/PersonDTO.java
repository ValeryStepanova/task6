package org.example.DTO;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonDTO {
    private int age;
    private double salary;
    private String passport;
    private  String address;
    private Date dateOdBirthday;
    private Timestamp dateTimeCreator;
    private Time timeToLunch;
    private String letter;

    @Override
    public String toString() {
        return "PersonDTO{" +
                "age=" + age +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", dateOdBirthday=" + dateOdBirthday +
                ", dateTimeCreator=" + dateTimeCreator +
                ", timeToLunch=" + timeToLunch +
                ", letter='" + letter + '\'' +
                '}';
    }
}
