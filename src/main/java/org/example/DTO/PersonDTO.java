package org.example.DTO;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Person")
public class PersonDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private int age;

    @Column
    private double salary;

    @Column
    private String passport;

    @Column
    private String address;

    @Column(name = "date_of_birthday")
    private Date dateOfBirthday;

    @Column(name = "date_time_create")
    private Timestamp dateTimeCreate;

    @Column(name = "time_to_lunch")
    private Time timeToLunch;

    @Column
    private String letter;

    @Override
    public String toString() {
        return "PersonDTO{" +
                "age=" + age +
                ", salary=" + salary +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", dateTimeCreate=" + dateTimeCreate +
                ", timeToLunch=" + timeToLunch +
                ", letter='" + letter + '\'' +
                '}';
    }
}
