package com.ridiculands;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class TestBigDecimal {
    public void testScale() {
        BigDecimal bd1 = new BigDecimal("0.0315");
        BigDecimal bd2 = new BigDecimal("10000");
        BigDecimal bd3 = bd1.divide(bd2, bd1.scale() + 4, RoundingMode.HALF_UP);
        System.err.println(bd1.scale());
        System.err.println(bd2.scale());
        System.err.println(BigInteger.valueOf(bd2.intValue()));
        System.err.println(bd3);
    }

    public void testInstantiate() {
        BigDecimal bd1 = new BigDecimal("107");
        BigDecimal bd2 = new BigDecimal("107");
        BigDecimal bd3 = BigDecimal.valueOf(1d);
        BigDecimal bd4 = BigDecimal.valueOf(1d);
        Long l1 = Long.valueOf(107L);
        Long l2 = Long.valueOf(107L);
        System.err.println(bd1.compareTo(bd3));
    }

    public static void main(String[] args) {
        TestBigDecimal tbd = new TestBigDecimal();
        tbd.testScale();
        tbd.testInstantiate();
    }
}
