package com.ridiculands;

import java.lang.reflect.Field;

public class TestReflection {

	private static final String AAA = "AAA";
	private static final String BBB = "BBB";
	private static final Integer III = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Field f = null;
			String s = null;
			f = TestReflection.class.getDeclaredField("AAA");
			if (f != null) {
				s = (String) f.get(null);
				System.err.println(s);
			}
			f = TestReflection.class.getDeclaredField("BBB");
			if (f != null) {
				s = (String) f.get(null);
				System.err.println(s);
			}
//			f = TestReflection.class.getDeclaredField("ZZZ");
//			if (f != null) {
//				s = (String) f.get(s);
//				System.err.println(s);
//			}

//			f = TestReflection.class.getDeclaredField("III");
//			if (f != null) {
//				s = (String) f.get(null);
//				System.err.println(s);
//			}

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
