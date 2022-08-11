package com.ridiculands;

import java.util.Arrays;
import java.util.List;

public class TestFindNumberOfUniquePairsInList {

    public void a() {

        List<String[]> input = Arrays.asList(
                new String[]{"Andy", "Ben"},
                new String[]{"Ben", "Andy"},
                new String[]{"Andy", "Ben"},
                new String[]{"Stephanie", "Ben"},
                new String[]{"Stephanie", "Chet"}
        );

        long count = input.stream()
                .map(i -> i[0] + " " + i[1])
//                .filter((e1, e2) -> !e1.equals(e2))
                .distinct()
                .count();
        System.out.println(count);
    }

    public static void main(String[] args) {
        TestFindNumberOfUniquePairsInList t = new TestFindNumberOfUniquePairsInList();
        t.a();
    }
}