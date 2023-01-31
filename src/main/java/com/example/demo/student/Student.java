package com.example.demo.student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;


//Entity and table for connecting to database
@Entity
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
//    ID and Sequence Generator for Database use
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate dob;
    private String email;
//    Making age transient element
//    Now we will not store it in database instead we will calculate it
//    using currDate - DOB
    @Transient
    private Integer age;

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
