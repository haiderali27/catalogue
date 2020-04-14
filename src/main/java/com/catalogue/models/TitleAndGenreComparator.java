package com.catalogue.models;

import java.util.Comparator;

public class TitleAndGenreComparator  implements Comparator<TitleAndGenre>{
	public int compare(TitleAndGenre obj1, TitleAndGenre obj2) {
        return obj1.getTitle().compareTo(obj2.getTitle());
    }
}
