package com.ridiculands.dto;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.math.BigDecimal;

public class TestSerialization {

    private static final String CAT_JSON = "{\"type\":\"cat\",\"name\":\"Tom\",\"age\":5,\"bodyLength\":30}";
    private static final String DOG_JSON = "{\"type\":\"dog\",\"name\":\"Amy\",\"age\":2,\"bodyLength\":40}";
    private static final String TURTLE_JSON = "{\"type\":\"turtle\",\"name\":\"Andrew\",\"age\":7,\"bodyLength\":15}";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSerializeCat() throws Exception {
        Cat cat = new Cat("Tom", 5, new BigDecimal("30"));
        String json = objectMapper.writeValueAsString(cat);
        System.err.println(json);
        assertThat(json, equalTo(CAT_JSON));
    }

    @Test
    public void testSerializeDog() throws Exception {
        Dog dog = new Dog("Amy", 2, new BigDecimal("40"));
        String json = objectMapper.writeValueAsString(dog);
        assertThat(json, equalTo(DOG_JSON));
    }

    @Test
    public void testSerializeTurtle() throws Exception {
        Turtle turtle = new Turtle("Andrew", 7, new BigDecimal("15"));
        String json = objectMapper.writeValueAsString(turtle);
        assertThat(json, equalTo(TURTLE_JSON));
    }

    @Test
    public <E extends LandAnimal> void testDeserializeCat() throws Exception {
        E animal = objectMapper.readValue(CAT_JSON, new TypeReference<>() {});
        animal.talk();
        assertThat(animal, isA(Cat.class));
        assertThat(animal, hasProperty("name", equalTo("Tom")));
        assertThat(animal, hasProperty("age", equalTo(5)));
        assertThat(animal, hasProperty("bodyLength", comparesEqualTo(new BigDecimal("30.00"))));
    }

    @Test
    public void testDeserializeDog() throws Exception {
        LandAnimal animal = objectMapper.readValue(DOG_JSON, LandAnimal.class);
        animal.talk();
        assertThat(animal, isA(Dog.class));
        assertThat(animal, hasProperty("name", equalTo("Amy")));
        assertThat(animal, hasProperty("age", equalTo(2)));
        assertThat(animal, hasProperty("bodyLength", comparesEqualTo(new BigDecimal("40.00"))));
    }

    @Test
    public void testDeserializeTurtle() throws Exception {
        LandAnimal animal = objectMapper.readValue(TURTLE_JSON, LandAnimal.class);
        animal.talk();
        assertThat(animal, isA(Turtle.class));
        assertThat(animal, hasProperty("name", equalTo("Andrew")));
        assertThat(animal, hasProperty("age", equalTo(7)));
        assertThat(animal, hasProperty("bodyLength", comparesEqualTo(new BigDecimal("15.00"))));
    }
}
