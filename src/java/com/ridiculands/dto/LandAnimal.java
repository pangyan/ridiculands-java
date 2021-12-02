package com.ridiculands.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Cat.class, name = "cat"),
    @JsonSubTypes.Type(value = Dog.class, name = "dog"),
    @JsonSubTypes.Type(value = Turtle.class, name = "turtle")
})
public abstract class LandAnimal {

    private final static Logger LOGGER = LoggerFactory.getLogger(LandAnimal.class);

    @JsonProperty
    protected String name;

    @JsonProperty
    protected Integer age;

    @JsonProperty
    protected BigDecimal bodyLength;

    public LandAnimal(String name, Integer age, BigDecimal bodyLength) {
        this.name = name;
        this.age = age;
        this.bodyLength = bodyLength;
    }

    public abstract void eat();

    public abstract void run();

    public void talk() {
        LOGGER.info("My name is {}.  I am a {}.  I am {} years old.", name, this.getClass().getSimpleName(), age);
    }

    public abstract void walk();

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getBodyLength() {
        return bodyLength;
    }
}
