package com.example.springboothibernate.persons;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    @Min(0)
    private int age;

    @Column(columnDefinition = "varchar(16) default 'Номер не указан'")
    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

    @Override
    public String toString() {
        return this.name + " " +
                this.surname + "; " +
                this.age + " лет; номер.тел: " +
                this.phoneNumber + "; Город проживания: " +
                this.cityOfLiving;
    }
}