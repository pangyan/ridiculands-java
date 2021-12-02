package com.ridiculands.dto;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.math.BigDecimal;

public class TestSerialization {

    private static final String CAT_JSON = "{\"type\":\"cat\",\"name\":\"Tom\",\"age\":5,\"bodyLength\":30}";
    private static final String DOG_JSON = "{\"type\":\"dog\",\"name\":\"Amy\",\"age\":2,\"bodyLength\":40}";
    private static final String TURTLE_JSON = "{\"type\":\"turtle\",\"name\":\"Andrew\",\"age\":7,\"bodyLength\":15}";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSerialize() throws Exception {
        Cat cat = new Cat("Tom", 5, new BigDecimal("30"));
        String json = objectMapper.writeValueAsString(cat);
        System.err.println(json);
    }

    @Test
    public void testDeserializeCat() throws Exception {
        LandAnimal animal = objectMapper.readValue(CAT_JSON, LandAnimal.class);
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
    }

    @Test
    public void testDeserializeTurtle() throws Exception {
        LandAnimal animal = objectMapper.readValue(TURTLE_JSON, LandAnimal.class);
        animal.talk();
    }

}
