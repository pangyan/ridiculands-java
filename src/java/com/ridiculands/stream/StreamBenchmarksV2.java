package com.ridiculands.stream;

import com.ridiculands.stream.benchmarkmethod.BenchmarkMethod;
import com.ridiculands.stream.benchmarkmethod.BenchmarkMethodFactory;
import com.ridiculands.stream.benchmarkmethod.sum.LargeArrayListBenchmarkMethodFactory;
import com.ridiculands.stream.benchmarkmethod.sum.LinkedListBenchmarkMethodFactory;
import com.ridiculands.stream.benchmarkmethod.sum.SmallArrayListBenchmarkMethodFactory;

public class StreamBenchmarksV2 {

    private static final int NUMBER_OF_RUNS = 1000;

    private final BenchmarkMethodFactory benchmarkMethodFactory;

    public StreamBenchmarksV2(BenchmarkMethodFactory benchmarkMethodFactory) {
        this.benchmarkMethodFactory = benchmarkMethodFactory;
    }

    private void measure(String name, BenchmarkMethod test) {
        long start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            test.execute();
        }
        long end = System.nanoTime();
//        System.out.println("Average execution time = " + (end - start) / NUMBER_OF_RUNS / 1000 + " microseconds");

        // csb output
        // test name,execution time in ms
        System.out.println(name + "," + (end - start) / NUMBER_OF_RUNS / 1000);
    }

    public void startBenchmark() {
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " loop", benchmarkMethodFactory.createLoopBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " sequential stream", benchmarkMethodFactory.createSequentialStreamBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " parallel stream", benchmarkMethodFactory.createParallelStreamBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " parallel stream", benchmarkMethodFactory.createParallelStreamBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " sequential stream", benchmarkMethodFactory.createSequentialStreamBenchmarkMethod());
        measure(benchmarkMethodFactory.getBenchmarkMethodName() + " loop", benchmarkMethodFactory.createLoopBenchmarkMethod());
    }

    public static void main(String[] args) {
        // initialize benchmark method factory
        // create your own BenchmarkMethodFactory and put it here for benchmarking your process
        BenchmarkMethodFactory benchmarkMethodFactory = new SmallArrayListBenchmarkMethodFactory();
//        BenchmarkMethodFactory benchmarkMethodFactory = new LargeArrayListBenchmarkMethodFactory();
//        BenchmarkMethodFactory benchmarkMethodFactory = new LinkedListBenchmarkMethodFactory();

        StreamBenchmarksV2 benchmarkApp = new StreamBenchmarksV2(benchmarkMethodFactory);
        benchmarkApp.startBenchmark();
    }
}
