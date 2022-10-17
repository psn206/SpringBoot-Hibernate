package com.example.springboothibernate;

import com.example.springboothibernate.persons.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class CommandLineApp implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Петр", "Иван", "Александр", "Сергей");
        var surnames = List.of("Петров", "Иванов", "Александров", "Сргеев");
        var ages = List.of(28, 11, 33, 45);
        var phoneNumber = List.of("2222", "3333", "4444", "5555");
        var citеs = List.of("Москва", "Курск", "Владивосток", "Москва");

        IntStream.range(0, names.size())
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(i))
                            .surname(surnames.get(i))
                            .age(ages.get(i))
                            .phoneNumber(phoneNumber.get(i))
                            .cityOfLiving(citеs.get(i))
                            .build();
                    entityManager.persist(person);
                });


    }
}
