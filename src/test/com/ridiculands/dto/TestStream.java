package com.ridiculands.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestStream {

    @Test
    public void test() {
        List<Dog> dogs = new ArrayList<>();
        Dog dog;
        dog = new Dog("D1", 2, new BigDecimal("2"));
        dogs.add(dog);
        dog = new Dog("D2", 3, new BigDecimal("3"));
        dog.setHobby(Optional.of("Hiking"));
        dogs.add(dog);
        dog = new Dog("D3", 4, new BigDecimal("4"));
        dogs.add(dog);
        dog = new Dog("D5", 5, new BigDecimal("5"));
        dogs.add(dog);

//        dogs.stream().map(d -> d.getHobby().map(h -> new Dog("D1", 2, new BigDecimal("2"))).ifPresent());
    }
}
