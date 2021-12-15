package com.ridiculands;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    private Map<String, List<String>> convertToDictionary() {
        return favorites.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1)));
    }

    public static void main(String[] args) {
        TestStream ts = new TestStream();
        System.err.println(ts.convertToDelimitedString());
        System.err.println(ts.convertToDictionary());
    }
}
