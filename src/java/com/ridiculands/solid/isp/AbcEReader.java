package com.ridiculands.solid.isp;

public class AbcEReader implements GenericEReader {
    @Override
    public void displayPdf() {
        System.out.println("display PDF");
    }

    @Override
    public void displayEpub() {
        System.out.println("display ePub");
    }

    @Override
    public void displayTxt() {
        System.out.println("display txt");
    }
}
