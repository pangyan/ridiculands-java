package com.ridiculands.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BenchmarkMethodFactory {
    public BenchmarkMethod createSmallArrayListLoopBenchmarkMethod() {
        return () -> {
            List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    public BenchmarkMethod createSmallArrayListSequentialStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    public BenchmarkMethod createSmallArrayListParallelStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }

    public BenchmarkMethod createLargeArrayListLoopBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    public BenchmarkMethod createLargeArrayListSequentialStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    public BenchmarkMethod createLargeArrayListParallelStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }

    public BenchmarkMethod createLargeLinkedListLoopBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    public BenchmarkMethod createLargeLinkedListSequentialStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    public BenchmarkMethod createLargeLinkedListParallelStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }
}
