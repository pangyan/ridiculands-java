package com.ridiculands;

public class TestStringSplit {

	public static void main(String[] args) {
		String feedAddress = "RDSS|EUR=";
		String feedAddress1 = "RDSS.EUR=";
		String[] findParameters = feedAddress.split("\\|");
		for (String s : findParameters) {
			System.err.println(s);
		}
		String[] findParameters1 = feedAddress1.split("\\.");
		for (String s : findParameters1) {
			System.err.println(s);
		}
		
	}
}
