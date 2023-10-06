package com.ridiculands.stream;

public interface BenchmarkMethodFactory {
    String getBenchmarkMethodName();
    BenchmarkMethod createLoopBenchmarkMethod();
    BenchmarkMethod createSequentialStreamBenchmarkMethod();
    BenchmarkMethod createParallelStreamBenchmarkMethod();
}
