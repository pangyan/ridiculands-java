package com.ridiculands;

import java.util.regex.Pattern;

public class TestRE {

	public static void main(String[] args) {
		final String re = "([a-zA-Z]:)?([\\\\/][a-zA-Z0-9_.-]+)+";
		String test1 = "C:\\result\\reutersdss";
		String test2 = "/result/reutersdss";
		String test3 = "/result/reutersdss/";
		String test4 = "C:\\result\\reutersdss\\";
		String test5 = "C:\\result\\reutersdss\\id_rsa.ppk";

		System.err.println("test1: " + Pattern.matches(re, test1));
		System.err.println("test2: " + Pattern.matches(re, test2));
		System.err.println("test3: " + Pattern.matches(re, test3));
		System.err.println("test4: " + Pattern.matches(re, test4));
		System.err.println("test5: " + Pattern.matches(re, test5));
	}

}
