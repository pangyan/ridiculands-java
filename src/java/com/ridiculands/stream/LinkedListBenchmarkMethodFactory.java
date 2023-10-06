package com.ridiculands.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedListBenchmarkMethodFactory implements BenchmarkMethodFactory {
    @Override
    public String getBenchmarkMethodName() {
        return "Linked List Benchmark";
    }

    @Override
    public BenchmarkMethod createLoopBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    @Override
    public BenchmarkMethod createSequentialStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    @Override
    public BenchmarkMethod createParallelStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }
}
