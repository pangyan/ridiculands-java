package com.ridiculands;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMultiThreading {
    private int i;
//    private int j;

    public void test() {
        CountDownLatch latch = new CountDownLatch(100);

        Runnable countingTask = () -> {
            System.err.println('[' + Thread.currentThread().getName() + "] " + i);
            i++;
//            j++;
            latch.countDown();
        };

        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executor.submit(countingTask);
        }

        try {
            latch.await();
        } catch (InterruptedException E) {
            // handle
        }

        executor.shutdown();

//        System.err.println("i = " + i + " j = " + j);
        System.err.println("i = " + i );
    }

    public void test1() {
        int numberOfThread = 5000;

        CountDownLatch latch = new CountDownLatch(numberOfThread);

        Runnable countingTask = () -> {
            System.err.println('[' + Thread.currentThread().getName() + "] " + i);
            i++;
            latch.countDown();
        };

        for (int i = 0; i < numberOfThread; i++) {
            new Thread(countingTask).start();
        }

        try {
            latch.await();
        } catch (InterruptedException E) {
            // handle
        }

        System.err.println("i = " + i );
    }

    public void test1a() throws InterruptedException {
        int numberOfThread = 5000;

        Thread[] threads = new Thread[numberOfThread];
        for (int i = 0; i < numberOfThread; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            });
            threads[i] = thread;
            thread.start();
        }

        for (int i = 0; i < numberOfThread; i++) {
            threads[i].join();
        }

        System.err.println("i = " + i );
    }

    public void test2() throws InterruptedException {
        int incrementCount = 2500;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int index=0; index<incrementCount; index++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int index=0; index<incrementCount; index++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.err.println("i = " + i );
    }

    private void reset() {
        i = 0;
    }

    private void increment() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        TestMultiThreading tmt = new TestMultiThreading();
        for (int j = 0; j < 100; j++) {
            tmt.reset();
            System.err.print("Run " + j + ' ');
            tmt.test2();
        }
    }
}

