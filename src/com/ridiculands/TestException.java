package com.ridiculands;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = null;

		try {
			a.length();
		} catch (Exception e) {
			System.err.println("Catched " + e.getMessage());
		}

	}

}
