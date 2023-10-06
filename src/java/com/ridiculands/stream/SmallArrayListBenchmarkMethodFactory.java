package com.ridiculands.stream;

import java.util.Arrays;
import java.util.List;

public class SmallArrayListBenchmarkMethodFactory implements BenchmarkMethodFactory {
    @Override
    public String getBenchmarkMethodName() {
        return "Small Array List Benchmark";
    }

    @Override
    public BenchmarkMethod createLoopBenchmarkMethod() {
        return () -> {
            List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = 0;
            for (int i = 0; i < l.size(); i++) {
                sum += l.get(i);
            }
        };
    }

    @Override
    public BenchmarkMethod createSequentialStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = l.stream().mapToInt(i -> i).sum();
        };
    }

    @Override
    public BenchmarkMethod createParallelStreamBenchmarkMethod() {
        return () -> {
            List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = l.parallelStream().mapToInt(i -> i).sum();
        };
    }
}
