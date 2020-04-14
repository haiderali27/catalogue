package com.catalogue.models;

public class Profile {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((preferredGenre == null) ? 0 : preferredGenre.hashCode());
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
		Profile other = (Profile) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (preferredGenre == null) {
			if (other.preferredGenre != null)
				return false;
		} else if (!preferredGenre.equals(other.preferredGenre))
			return false;
		return true;
	}
	public Profile() {
		super();
		this.name = null;
		this.preferredGenre = null;
	}
	public Profile(String name, Integer preferredGenre) {
		super();
		this.name = name;
		this.preferredGenre = preferredGenre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPreferredGenre() {
		return preferredGenre;
	}
	public void setPreferredGenre(Integer preferredGenre) {
		this.preferredGenre = preferredGenre;
	}
	String name;
	Integer preferredGenre;
}
