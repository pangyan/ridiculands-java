package com.ridiculands;

import com.ridiculands.product.FX;
import com.ridiculands.product.FXFlexiForward;
import com.ridiculands.product.FXSwap;

public class TestInstanceOf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FX fx = new FX();
		FXFlexiForward fxFlexiForward = new FXFlexiForward();
		FXSwap fxSwap = new FXSwap();

		System.err.println(fx instanceof FX);
		System.err.println(fxFlexiForward instanceof FX);
		System.err.println(fxSwap instanceof FX);

		System.err.println(fx instanceof FXFlexiForward);
		System.err.println(fxFlexiForward instanceof FXFlexiForward);
//		System.err.println(fxSwap instanceof FXFlexiForward);

		System.err.println(fx instanceof FXSwap);
//		System.err.println(fxFlexiForward instanceof FXSwap);
		System.err.println(fxSwap instanceof FXSwap);

		FX temp = null;
		temp = (FX) fxFlexiForward;
		temp = (FX) fxSwap;
		
		
	}

}
