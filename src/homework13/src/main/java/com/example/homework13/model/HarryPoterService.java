package com.example.homework13.model;

import com.github.javafaker.Faker;
import com.github.javafaker.HarryPotter;
import org.springframework.stereotype.Component;

@Component
public class HarryPoterService {

    private static Faker faker = new Faker();

    public String getRandomCharacter(){
        HarryPotter hp = faker.harryPotter();
        return hp.character();
    }
}
