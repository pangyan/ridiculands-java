package com.ridiculands.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *    size: 100000
 *    pipeline: list --> stream --> map --> sum
 *    collection: arrayList
 */
public class LargeArrayListBenchmarkMethodFactory implements BenchmarkMethodFactory {
    @Override
    public String getBenchmarkMethodName() {
        return "Large Array List Benchmark";
    }

    @Override
    public BenchmarkMethod createLoopBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    @Override
    public BenchmarkMethod createSequentialStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    @Override
    public BenchmarkMethod createParallelStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = IntStream.range(1, 100001).boxed().collect(Collectors.toList());
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }
}
