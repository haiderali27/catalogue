package com.catalogue.models;

public class TitleAndYear {
	public TitleAndYear(String title, Integer year) {
		super();
		this.title = title;
		this.year = year;
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
	private String title;
	private Integer year;

}
