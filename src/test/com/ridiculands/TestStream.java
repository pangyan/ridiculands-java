package com.ridiculands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

    List<String> favorites = Arrays.asList("Apple",
            "Beer",
            "Beet",
            "Orange",
            "Pear");

    private String convertToDelimitedString() {
        return favorites.stream()
                .filter(s -> s.contains("Bee"))
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        TestStream ts = new TestStream();
        System.err.println(ts.convertToDelimitedString());
    }
}
