package com.forex.analysis.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class CollectionUtils {

/**
 * Removes items from the list based on their indexes.
 * 
 * @param list
 *            list
 * @param indexes
 *            indexes this collection must be sorted in ascending order
 */
public static <T> void remove(final List<T> list,
        final Collection<Integer> indexes) {
    int i = 0;
    for (final int idx : indexes) {
        list.remove(idx - i++);
    }
}

/**
 * Splits the given list in segments of the specified size.
 * 
 * @param list
 *            list
 * @param segmentSize
 *            segment size
 * @return segments
 */
public static <T> List<List<T>> splitList(final List<T> list,
        final int segmentSize) {
    int from = 0, to = 0;
    final List<List<T>> result = new ArrayList<>();

    while (from < list.size()) {
        to = from + segmentSize;
        if (to > list.size()) {
            to = list.size();
        }
        result.add(new ArrayList<T>(list.subList(from, to)));
        from = to;
    }

    return result;
}

public static List<List<Float>> convertToNewLists(List<List<Float>> splitList) {
	return splitList;
//	List<List<Float>> newLists = new ArrayList<List<Float>>();
//    final int N = list.size();
//    for (int i = 0; i < N; i += L) {
//        parts.add(new ArrayList<T>(
//            list.subList(i, Math.min(N, i + L)))
//        );
//    }
//    return parts;
}

}