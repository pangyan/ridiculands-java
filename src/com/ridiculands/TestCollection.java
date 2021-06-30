package com.ridiculands;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCollection {

    private static final int LIST_SIZE = 1000;
    private static final int NO_OF_TRIES = 10;

    private List<String> names;

    private void init() {
        names = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            names.add(String.valueOf(i));
        }
    }

    public void loopByStream() {
        names.stream().filter(s -> s.equals("167")).forEach(s -> {System.err.println(s);});
    }

    public void loopByFor() {
        for (String s : names) {
            if (s.equals("167")) {
                System.err.println(s);
            }
        }
    }

    public static void main(String[] args) {
        TestCollection test = new TestCollection();
        test.init();
        long start = System.nanoTime();
        for (int i = 0; i < NO_OF_TRIES; i++) {
            test.loopByFor();
        }
        System.err.println((System.nanoTime() - start) / NO_OF_TRIES);
    }
}
