package com.ridiculands.stream.benchmarkmethod;

public interface BenchmarkMethodFactory {
    String getBenchmarkMethodName();
    BenchmarkMethod createLoopBenchmarkMethod();
    BenchmarkMethod createSequentialStreamBenchmarkMethod();
    BenchmarkMethod createParallelStreamBenchmarkMethod();
}
