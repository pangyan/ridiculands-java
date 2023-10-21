package com.ridiculands.stream.benchmarkmethod.sum;

import com.ridiculands.stream.benchmarkmethod.BenchmarkMethod;
import com.ridiculands.stream.benchmarkmethod.BenchmarkMethodFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *    size: small - 10
 *    pipeline: list --> stream --> map --> sum
 *    operation: sum
 *    collection: arrayList
 */
public class ArrayListBenchmarkMethodFactory implements BenchmarkMethodFactory {
    private static List<Integer> l;
    private int collectionSize;

    public ArrayListBenchmarkMethodFactory(int collectionSize) {
        l = IntStream.range(1, collectionSize + 1).boxed().collect(Collectors.toList());
        this.collectionSize = collectionSize;
    }

    @Override
    public String getBenchmarkMethodName() {
        return "Array List Benchmark - " + collectionSize + " elements";
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
