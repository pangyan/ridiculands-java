package com.ridiculands;

public class TestCasting {

	private void a() {
		Object conn = null;
		String b = (String) conn;
		System.err.println(b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCasting t = new TestCasting();
		t.a();

	}

}
