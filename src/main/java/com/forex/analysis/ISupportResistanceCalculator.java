package com.forex.analysis;
import java.util.List;

import com.forex.analysis.model.Tuple;
import com.forex.analysis.model.technical.Level;

public interface ISupportResistanceCalculator {

/**
 * Identifies support / resistance levels.
 * 
 * @param timeseries
 *            timeseries
 * @param beginIndex
 *            starting point (inclusive)
 * @param endIndex
 *            ending point (exclusive)
 * @param segmentSize
 *            number of elements per internal segment
 * @param rangePct
 *            range % (Example: 1.5%)
 * @return A tuple with the list of support levels and a list of resistance
 *         levels
 */
Tuple<List<Level>, List<Level>> identify(List<Float> timeseries,
        int beginIndex, int endIndex, int segmentSize, float rangePct);
}