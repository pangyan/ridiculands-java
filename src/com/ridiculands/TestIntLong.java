package com.ridiculands;

public class TestIntLong {

	public void testInt(int i) {
		System.err.println("testInt: " + i);
	}

	public void testLong(long l) {
		System.err.println("testLong: " + l);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestIntLong til = new TestIntLong();

		int i = 1;
		long l = 1L;
		til.testInt(i);
		til.testLong(i);

//		til.testInt(l);  <-- compilation error
		til.testLong(l);

	}

}
