package com.ridiculands.designpattern;

public class DumplingMaker {
    enum DumplingType {
        LAMB,
        PORK,
        SHRIMP,
        VEGETABLE
    }

    // TODO refactor this
    public void makeDumpling(DumplingType type) {
        if (type == DumplingType.LAMB) {
            // make lamb dumplings
            // ...
            // ...
            return;
        }
        if (type == DumplingType.PORK) {
            // make pork dumplings
            // ...
            // ...
            return;
        }
        if (type == DumplingType.SHRIMP) {
            // make shrimp dumplings
            // ...
            // ...
            return;
        }
        if (type == DumplingType.VEGETABLE) {
            // make vegetable dumplings
            // ...
            // ...
            return;
        }
    }
}
