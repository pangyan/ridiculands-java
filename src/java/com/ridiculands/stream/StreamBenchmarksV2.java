package com.ridiculands.stream;

import com.ridiculands.stream.benchmarkmethod.BenchmarkMethod;
import com.ridiculands.stream.benchmarkmethod.BenchmarkMethodFactory;

public class StreamBenchmarksV2 {

    private static final int NUMBER_OF_RUNS = 1000;

    private final BenchmarkMethodFactory benchmarkMethodFactory;

    public StreamBenchmarksV2(BenchmarkMethodFactory benchmarkMethodFactory) {
        this.benchmarkMethodFactory = benchmarkMethodFactory;
    }

    private void measure(String name, BenchmarkMethod test) {
        measure(name, test, NUMBER_OF_RUNS);
    }

    private void measure(String name, BenchmarkMethod test, int numberOfRuns) {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfRuns; i++) {
            test.execute();
        }
        long end = System.nanoTime();
//        System.out.println("Average execution time = " + (end - start) / NUMBER_OF_RUNS / 1000 + " microseconds");

        // csb output
        // test name,execution time in nanoseconds
        System.out.println(name + "," + (end - start) / numberOfRuns);
    }

    public void startBenchmark() {
        // warm up
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " loop - warmup", benchmarkMethodFactory.createLoopBenchmarkMethod(), 10);
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " sequential stream - warmup", benchmarkMethodFactory.createSequentialStreamBenchmarkMethod(), 10);
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " parallel stream - warmup", benchmarkMethodFactory.createParallelStreamBenchmarkMethod(), 10);

        // benchmark
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " loop", benchmarkMethodFactory.createLoopBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " sequential stream", benchmarkMethodFactory.createSequentialStreamBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " parallel stream", benchmarkMethodFactory.createParallelStreamBenchmarkMethod());
    }

    public static void main(String[] args) throws Exception {
        // initialize benchmark method factory
        // create your own BenchmarkMethodFactory and put it here for benchmarking your process
        com.ridiculands.stream.benchmarkmethod.sum.ArrayListBenchmarkMethodFactory benchmarkMethodFactory =
                new com.ridiculands.stream.benchmarkmethod.sum.ArrayListBenchmarkMethodFactory(1000000);

        StreamBenchmarksV2 benchmarkApp = new StreamBenchmarksV2(benchmarkMethodFactory);
        benchmarkApp.startBenchmark();
    }
}
