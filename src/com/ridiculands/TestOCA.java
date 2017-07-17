package com.ridiculands;

public class TestOCA {
	private static int $;
	public static void main(String[] args) {
		// 1
		String a_b = null;
//		System.out.print($);
//		System.out.print(a_b);

		// 4
		boolean keepGoing = true;
		int count = 0;
		int x = 3;
		while (count++ < 3) {
			int y = (1 + 2 * count) % 3;
//			System.out.println("y: " + y);
			switch(y) {
				default:
				case 0: x -= 1; break;
				case 1: x += 5;
			}
//			System.out.println("x: " + x);
		}

		// 5
		System.out.println("A");
		try {
			System.out.println("B");
			throw new IllegalArgumentException();
		} catch (RuntimeException e) {
			System.out.println("C");
		} finally {
			System.out.println("D");
		}
		System.out.println("E");
	}

	// 
	public interface Animal { public default String getName() { return null; } }
	interface Mammal { public default String getName() { return null; } }
	abstract class Otter implements Mammal, Animal { @Override public String getName() { return "DNLM!"; } }


}
