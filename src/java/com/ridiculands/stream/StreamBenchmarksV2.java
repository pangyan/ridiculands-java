package com.ridiculands.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamBenchmarksV2 {

    private Function<List<Integer>, Integer> testLoop() {
        return l -> {
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
            return sum;
        };
    }

    private Function<List<Integer>, Integer> testSequentialStream() {
        return l -> l.stream().mapToInt(i -> i).sum();
    }

    private Function<List<Integer>, Integer> testParallelStream() {
        return l -> l.parallelStream().mapToInt(i -> i).sum();
    }

    private void measure(Function<List<Integer>, Integer> test, List<Integer> testData) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            test.apply(testData);
        }
        long end = System.nanoTime();
        System.out.println("Average execution time = " + (end - start) / 1000 / 1000 + " microseconds");
    }
    public static void main(String[] args) {
        StreamBenchmarksV2 benchmark = new StreamBenchmarksV2();
        benchmark.measure(benchmark.testLoop(), Arrays.asList(1, 2, 3, 4, 5));
        benchmark.measure(benchmark.testSequentialStream(), Arrays.asList(1, 2, 3, 4, 5));
        benchmark.measure(benchmark.testParallelStream(), Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("===== DNLM =====");

        benchmark.measure(benchmark.testLoop(), IntStream.range(1, 1000001).boxed().collect(Collectors.toList()));
        benchmark.measure(benchmark.testSequentialStream(), IntStream.range(1, 1000001).boxed().collect(Collectors.toList()));
        benchmark.measure(benchmark.testParallelStream(), IntStream.range(1, 1000001).boxed().collect(Collectors.toList()));

        System.out.println("===== DNLM =====");

        benchmark.measure(benchmark.testLoop(), IntStream.range(1, 1001).boxed().collect(Collectors.toCollection(LinkedList::new)));
        benchmark.measure(benchmark.testSequentialStream(), IntStream.range(1, 1001).boxed().collect(Collectors.toCollection(LinkedList::new)));
        benchmark.measure(benchmark.testParallelStream(), IntStream.range(1, 1001).boxed().collect(Collectors.toCollection(LinkedList::new)));
    }

}
