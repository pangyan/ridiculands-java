package com.ridiculands;

public class TestConstructor {
	
	public void testInstantiate() {
		A a1 = new A("111", "222");
		A a2 = new A("111", "222", "333", "444", "555");

		System.err.println(a1.toString());
		System.err.println(a2.toString());
	}

	public static void main(String[] args) {
		TestConstructor t = new TestConstructor();
		t.testInstantiate();
	}

	class A {
		private String attr1;
		private String attr2;
		private String attr3;
		private String attr4;
		private String attr5;

		A(String a1, String a2) {
//			this.attr1 = a1;
//			this.attr2 = a2;
			this(a1, a2, "N/A", "N/A", "N/A");
		}

		A(String a1, String a2, String a3, String a4, String a5) {
			this.attr1 = a1;
			this.attr2 = a2;
			this.attr3 = a3;
			this.attr4 = a4;
			this.attr5 = a5;
		}

		@Override
		public String toString() {
			return attr1 + "/" + attr2 + "/" + attr3 + "/" + attr4 + "/" + attr5;
		}
	}
}