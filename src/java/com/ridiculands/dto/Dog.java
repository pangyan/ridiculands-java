package com.ridiculands.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

@JsonTypeName("dog")
@JsonSerialize(as = Dog.class)
@JsonDeserialize(as = Dog.class)
public class Dog extends LandAnimal {

    @JsonCreator
    public Dog(@JsonProperty("name") String name,
               @JsonProperty("age") Integer age,
               @JsonProperty("bodyLength") BigDecimal bodyLength) {
        super(name, age, bodyLength);
    }

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    @Override
    public void walk() {

    }
}
