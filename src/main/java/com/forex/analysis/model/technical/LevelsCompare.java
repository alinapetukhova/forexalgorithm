package com.forex.analysis.model.technical;

import java.util.Comparator;

public class LevelsCompare implements Comparator<Level> {

	@Override
	public int compare(Level o1, Level o2) {
		return o1.getLevel().compareTo(o2.getLevel());
	}

}
