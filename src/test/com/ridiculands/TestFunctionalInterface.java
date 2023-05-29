package com.ridiculands;

@FunctionalInterface
public interface TestFunctionalInterface {
    abstract void method();
    default void refresh(){}
    private static void method1(){}
}
