package com.ridiculands.stream.benchmarkmethod.sum;

import com.ridiculands.stream.benchmarkmethod.BenchmarkMethod;
import com.ridiculands.stream.benchmarkmethod.BenchmarkMethodFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *    size: medium - 10000
 *    pipeline: list --> stream --> map --> sum
 *    operation: sum
 *    collection: linkedList
 */
public class LinkedListBenchmarkMethodFactory implements BenchmarkMethodFactory {
    private static final List<Integer> l = IntStream.range(1, 10001).boxed().collect(Collectors.toCollection(LinkedList::new));

    @Override
    public String getBenchmarkMethodName() {
        return "Linked List Benchmark";
    }

    @Override
    public BenchmarkMethod createLoopBenchmarkMethod() {
        return () -> {
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    @Override
    public BenchmarkMethod createSequentialStreamBenchmarkMethod() {
        return () -> {
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    @Override
    public BenchmarkMethod createParallelStreamBenchmarkMethod() {
        return () -> {
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }
}
