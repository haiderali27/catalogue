package com.catalogue.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fid",scope = Film.class)
public class Film {
	
	public Film() {
		super();
		this.fid = null;
		this.title = null;
		this.year = null;
		this.genre = null;
		this.cast=null;
		this.director = null;
		this.description = null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fid == null) ? 0 : fid.hashCode());
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
		Film other = (Film) obj;
		if (fid == null) {
			if (other.fid != null)
				return false;
		} else if (!fid.equals(other.fid))
			return false;
		return true;
	}

	public Film(Integer fid, String title, Integer year, List<Integer> cast, List<Integer> genre, Integer director,
			String description) {
		super();
		this.fid = fid;
		this.title = title;
		this.year = year;
		this.cast = cast;
		this.genre = genre;
		this.director = director;
		this.description = description;
	}

	Integer fid;
	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
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

	public List<Integer> getCast() {
		return cast;
	}

	public void setCast(List<Integer> cast) {
		this.cast = cast;
	}

	public List<Integer> getGenre() {
		return genre;
	}

	public void setGenre(List<Integer> genre) {
		this.genre = genre;
	}

	public Integer getDirector() {
		return director;
	}

	public void setDirector(Integer director) {
		this.director = director;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String title;
	Integer year;
	List<Integer> cast;
	List<Integer> genre;
	Integer director;
	String description;
	
}
