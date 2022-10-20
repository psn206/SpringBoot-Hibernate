package com.example.springboothibernate.controller;

import com.example.springboothibernate.persons.Person;
import com.example.springboothibernate.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public List<String> getPersonsByCity(@RequestParam String city) {
        List<String> result = personRepository.findByCityOfLiving(city).stream()
                .map(Person::toString)
                .collect(Collectors.toList());
        return result;
    }

    @GetMapping("/persons/by-age")
    public List<String> getPersonsByAge(@RequestParam int age) {
        List<String> result = personRepository.findByAgeLessThanOrderByAgeDesc(age).stream()
                .map(Person::toString)
                .collect(Collectors.toList());
        return result;
    }



    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person>  getPersonsByName (@RequestParam String name, @RequestParam String surname) {
        return   personRepository.findAllByNameAndSurname(name, surname);

    }
}
