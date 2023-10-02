package com.ridiculands.stream;

public class StreamBenchmarksV2 {

    private static final int NUMBER_OF_RUNS = 1000;

    private void measure(String name, BenchmarkMethod test) {
        long start = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            test.execute();
        }
        long end = System.nanoTime();
//        System.out.println("Average execution time = " + (end - start) / NUMBER_OF_RUNS / 1000 + " microseconds");

        // test name,execution time in ms
        System.out.println(name + "," + (end - start) / NUMBER_OF_RUNS / 1000);
    }

    public static void main(String[] args) {
        BenchmarkMethodFactory factory = new BenchmarkMethodFactory();
        StreamBenchmarksV2 benchmark = new StreamBenchmarksV2();
        benchmark.measure("small array list loop", factory.createSmallArrayListLoopBenchmarkMethod());
        benchmark.measure("small array list sequential", factory.createSmallArrayListSequentialStreamBenchmarkMethod());
        benchmark.measure("small array list parallel", factory.createSmallArrayListParallelStreamBenchmarkMethod());

        System.out.println("===== DNLM =====");

        benchmark.measure("large array list loop", factory.createLargeArrayListLoopBenchmarkMethod());
        benchmark.measure("large array list sequential", factory.createLargeArrayListSequentialStreamBenchmarkMethod());
        benchmark.measure("large array list parallel", factory.createLargeArrayListParallelStreamBenchmarkMethod());

        System.out.println("===== DNLM =====");

        benchmark.measure("large linked list loop", factory.createLargeLinkedListLoopBenchmarkMethod());
        benchmark.measure("large linked list sequential", factory.createLargeLinkedListSequentialStreamBenchmarkMethod());
        benchmark.measure("large linked list parallel", factory.createLargeLinkedListParallelStreamBenchmarkMethod());
    }
}
