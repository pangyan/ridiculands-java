package com.ridiculands;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
	private static Map<String, String> feedHandlerMap = new ConcurrentHashMap<String, String>();
	
	public void test() {
		feedHandlerMap.put("NotNull", "ABC");
		
//		feedHandlerMap.get(null);
		
		feedHandlerMap.get("NotNull").length();
		feedHandlerMap.get("Null").length();
		
		
	}

	public static void main(String[] args) {
		TestConcurrentHashMap test = new TestConcurrentHashMap();
		test.test();
	}
}
