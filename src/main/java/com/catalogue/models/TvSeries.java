package com.catalogue.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tid",scope = TvSeries.class)

public class TvSeries {
	@Override
	public int hashCode() {
		final int prime = 32;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TvSeries other = (TvSeries) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}
	public TvSeries() {
		super();
		this.tid = null;
		this.title = null;
		this.year = null;
		this.genre = null;
		this.creator = null;
		this.cast = null;
		this.description = null;
	}
	public TvSeries(Integer tid, String title, Integer year, List<Integer> genreIds, Integer creatorId,
			List<Integer> castIds, String description) {
		super();
		this.tid = tid;
		this.title = title;
		this.year = year;
		this.genre = genreIds;
		this.creator = creatorId;
		this.cast = castIds;
		this.description = description;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public List<Integer> getGenre() {
		return genre;
	}
	public void setGenre(List<Integer> genre) {
		this.genre = genre;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public List<Integer> getCast() {
		return cast;
	}
	public void setCast(List<Integer> cast) {
		this.cast = cast;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	Integer tid;
	String title;
	Integer year;
	List<Integer> genre;
	Integer creator;
	List<Integer> cast;
	String description;
}
