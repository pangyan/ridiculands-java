package com.ridiculands;

public class TestCondition {

    public static void main(String[] args) {
        int t = 8;

        if (t % 4 == 0) {
            System.err.println("can be divided by 4");
        } else if (t % 2 == 0) {
            System.err.println("can be divided by 2");
        } else {
            System.err.println("DNLM");
        }
    }
}
