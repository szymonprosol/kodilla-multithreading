package com.kodilla.multi.task;

public class PartialCalc implements Runnable {
    private Reducer reducer;
    private int[] elements;
    private int lowerIndex;
    private int upperIndex;

    public PartialCalc(Reducer reducer, int[] elements, int lowerIndex, int upperIndex) {
        this.reducer = reducer;
        this.elements = elements;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }

    @Override
    public void run() {
        for (int n = lowerIndex; n < upperIndex; n++) {
            reducer.multiply(elements[n]);
        }
    }
}