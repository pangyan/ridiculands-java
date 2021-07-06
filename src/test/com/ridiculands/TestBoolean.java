package com.ridiculands;

public class TestBoolean {

	public static void main(String[] args) {
		System.err.println(new Boolean("true"));
		System.err.println(new Boolean("false"));
		System.err.println(new Boolean("TRUE"));
		System.err.println(new Boolean("FALSE"));
		System.err.println(new Boolean("Rubbish"));
		System.err.println(new Boolean(""));
		System.err.println(new Boolean(null));
	}
}
