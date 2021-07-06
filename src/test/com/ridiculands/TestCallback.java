package com.ridiculands;

public class TestCallback {

	public void a() {
		Object result = b();
		System.err.println((result == null)? "NULL!": "NOT NULL!");
	}

	public Object b() {
		Object result = null;
		c(result);
		return result;
	}

	public void c(Object result) {
		Object temp = new Object();
		result = new Object();
	}

	public static void main(String[] args) {
		TestCallback test = new TestCallback();
		test.a();
	}
	
}
