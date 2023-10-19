package com.ridiculands.stream.benchmarkmethod.sum;

import com.ridiculands.stream.benchmarkmethod.BenchmarkMethod;
import com.ridiculands.stream.benchmarkmethod.BenchmarkMethodFactory;

import java.util.Arrays;
import java.util.List;

/**
 *    size: small - 10
 *    pipeline: list --> stream --> map --> sum
 *    operation: sum
 *    collection: arrayList
 */
public class SmallArrayListBenchmarkMethodFactory implements BenchmarkMethodFactory {
    private static final List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public String getBenchmarkMethodName() {
        return "Small Array List Benchmark";
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
