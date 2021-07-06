package com.ridiculands;

import java.util.Locale;

public class TestEnum {

	private enum QuoteType {
		CLEANPRICE(100.),
		DIRTYPRICE(100.),
		PRICE(1.),
		PRICE32(100.),
		PRICE64(100.),
		FUTURE(1.),
		FUTURE32(100.),
		FUTURE64(100.),
		YIELD(1.),
		PRICEC(1.),
		PRICEVOL(1.),
		SPREAD(1.);

		double quoteTypeStoreFactor;
		
		QuoteType(double quoteTypeStoreFactor) {
			this.quoteTypeStoreFactor = quoteTypeStoreFactor;
		}

		public double getQuoteTypeStoreFactor() {
			return this.quoteTypeStoreFactor;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(QuoteType.valueOf("CleanPrice".toUpperCase(Locale.US)).getQuoteTypeStoreFactor());
		
		System.err.println(QuoteType.valueOf("CleanPrice".toUpperCase(Locale.US)).getClass().getName());
		System.err.println(QuoteType.CLEANPRICE.getClass().getName());

		System.err.println(QuoteType.valueOf("AAA".toUpperCase(Locale.US)).getQuoteTypeStoreFactor());

	}

}
