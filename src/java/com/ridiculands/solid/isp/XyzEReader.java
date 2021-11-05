package com.ridiculands.solid.isp;

public class XyzEReader implements GenericEReader {

    @Override
    public void displayPdf() {
        System.out.println("display PDF");
    }

    @Override
    public void displayEpub() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void displayTxt() {
        throw new UnsupportedOperationException();
    }
}
