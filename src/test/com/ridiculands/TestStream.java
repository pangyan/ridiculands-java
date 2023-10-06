package com.ridiculands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    List<String> favorites = Arrays.asList("Apple",
            "Beer",
            "Beet",
            "Orange",
            "Pear");

    List<String[]> pairs = Arrays.asList(
            new String[] {"Apple", "Beer"},
            new String[] {"Beer", "Apple"},
            new String[] {"Bee", "rApple"},
            new String[] {"Apple", "Beer"},
            new String[] {"Orange", "Beer"},
            new String[] {"Orange", "Pear"}
    );

    private String convertToDelimitedString() {
        return favorites.stream()
                .filter(s -> s.contains("Bee"))
                .collect(Collectors.joining(","));
    }

    private Map<String, Set<String>> convertToDictionary() {
        return favorites.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.mapping(s -> s, Collectors.toSet())));
    }

    private int countUniquePairs() {
        return pairs.stream()
                .map(strings -> strings[0] + ',' + strings[1])
                .distinct()
                .mapToInt(i -> 1)
                .reduce((a, b) -> a + b)
                .orElse(0);
    }

    private void flatMap() {
        System.err.println(favorites.stream().flatMap(s -> Stream.of(s, s + s)).collect(Collectors.toSet()));

        try {
            Stream<String> lines = Files.lines(Paths.get("/Users/pangyanwong/CodeDepot/ridiculands-java/docs/test.txt"));
            lines.map(line -> line.split("\\s+")) // Stream<String[]>
                    .flatMap(Arrays::stream)
                    .distinct() // Stream<String[]>
                    .forEach(System.out::println);;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void transform() {
        Map<String, Set<DayOfWeek>> data = new HashMap<>();
        data.put("A", Set.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY));
        data.put("B", Set.of(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY));
        data.put("C", Set.of(DayOfWeek.MONDAY, DayOfWeek.FRIDAY));
        data.put("D", Set.of(DayOfWeek.WEDNESDAY));
        data.put("E", Set.of(DayOfWeek.FRIDAY));

        Map<DayOfWeek, List<String>> result = data.keySet().stream()
                .flatMap(name -> data.get(name).stream().map(dayOfWeek -> new AbstractMap.SimpleEntry<>(dayOfWeek, name)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        System.err.println(result);

        BiConsumer<List, String> a = List::add;
    }

    public static void main(String[] args) {
        TestStream ts = new TestStream();
        System.err.println(ts.convertToDelimitedString());
        System.err.println(ts.convertToDictionary());
        System.err.println(ts.countUniquePairs());

        ts.flatMap();
        ts.transform();
    }
}
