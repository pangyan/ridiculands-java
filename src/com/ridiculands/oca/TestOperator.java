package com.ridiculands.oca;

public class TestOperator {

	public void testBinary() {
		System.err.println(0b11111111);
		System.err.println(0b11111110 & 0b11111111);
		System.err.println(0b11111110 | 0b11111111);
		System.err.println(0b11111110 ^ 0b11111111);

		System.err.println("_____________________________________");
	}
	
	public void testBitwiseShift() {
		int x = 2;
		System.err.println(x >> 1);
		System.err.println(x << 1);
		System.err.println(x >>> 1);
		System.err.println(-2 >> 1);
		System.err.println(-2 >>> 1);
		System.err.println(x);

		System.err.println("_____________________________________");
	}

	public void testPrePostIncrement() {
		// post increment
		int x = 0;
		System.err.println(x++ == 0);
		System.err.println(x++);
		System.err.println(x);

		// pre increment
		int y = 0;
		System.err.println(++y == 0);
		System.err.println(++y);
		System.err.println(y);

		System.err.println("_____________________________________");
	}

	public static void main(String[] args) {
		TestOperator to = new TestOperator();
		to.testPrePostIncrement();
		to.testBinary();
		to.testBitwiseShift();
	}

}
