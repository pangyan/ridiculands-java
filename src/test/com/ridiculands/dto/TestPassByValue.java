package com.ridiculands.dto;

import java.math.BigDecimal;

public class TestPassByValue {

    public void bath(Dog dog1, Dog dog2) {
        Dog tempDog = dog1;
        dog1 = dog2;
        dog2 = tempDog;
        System.err.println("inside bath: " + dog1.getName());
        dog1.name = "Cat";
        dog2.name = "Doo";
        System.err.println("inside bath: " + dog1.getName());
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("Arr", 1, new BigDecimal("30"));
        Dog dog2 = new Dog("Bee", 2, new BigDecimal("50"));
        TestPassByValue t = new TestPassByValue();
        t.bath(dog1, dog2);
        System.err.println(dog1.getName());
        System.err.println(dog2.getName());
    }

}
