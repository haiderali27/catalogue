package com.catalogue.models;

import java.util.Comparator;

public class TitleAndYearComparator  implements Comparator<TitleAndYear> {
	public int compare(TitleAndYear obj1, TitleAndYear obj2) {
        return obj1.getTitle().compareTo(obj2.getTitle());
    }
}
