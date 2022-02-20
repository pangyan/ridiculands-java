package com.ridiculands.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

@JsonSerialize(as = Cat.class)
@JsonDeserialize(as = Cat.class)
public class Cat extends LandAnimal {

    @JsonCreator
    public Cat(@JsonProperty("name") String name,
               @JsonProperty("age") Integer age,
               @JsonProperty("bodyLength") BigDecimal bodyLength) {
        super(name, age, bodyLength);
    }

    @Override
    public void eat() {
        Object o = new Object();
        o.equals(o);
    }

    @Override
    public void run() {

    }

    @Override
    public void walk() {

    }
}
