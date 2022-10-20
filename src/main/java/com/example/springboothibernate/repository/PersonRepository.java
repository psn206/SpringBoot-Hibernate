package com.example.springboothibernate.repository;

import com.example.springboothibernate.persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository <Person, Long>{

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAgeDesc(int age);


    Optional<Person> findAllByNameAndSurname(String name, String surname);
}