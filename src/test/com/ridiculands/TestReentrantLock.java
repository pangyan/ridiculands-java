package com.ridiculands;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Worker("Thread 1"));
        Thread thread2 = new Thread(new Worker("Thread 2"));

        thread1.start();
        thread2.start();
    }

    static class Worker implements Runnable {
        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is trying to acquire the lock.");
            lock.lock();

            try {
                System.out.println(name + " has acquired the lock.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + " is releasing the lock.");
                lock.unlock();
            }
        }
    }
}
