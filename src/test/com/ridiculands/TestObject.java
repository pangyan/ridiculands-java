package com.ridiculands;

import java.util.Objects;

public class TestObject {

    private int id;
    private String name;

    public void test() {
        Object o1 = new Object();
        Object o2 = new Object();
        System.err.println(o1.hashCode());
        System.err.println(o2.hashCode());
    }

    public static void main(String[] args) {
        TestObject t = new TestObject();
        t.test();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
