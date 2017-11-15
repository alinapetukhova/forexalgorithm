package com.forex.analysis.calculator.mean;

public class IMeanCalculator {

	public float mean(Float[] array, int i, int size) {
		float sum = 0;
	    while (i < size) {
	        sum += array[i];
	        i++;
	    }
	    return sum / size;
	}

}
