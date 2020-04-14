package com.catalogue.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ItemContainer {
	public ItemContainer() {
		super();
		this.films = null;
		this.genres = null;
		this.people = null;
		this.profiles = null;
		this.tvseries = null;		
	}
	public ItemContainer(List<Film> films, List<TvSeries> tvSeries, List<Genre> genres, List<People> people, List<Profile> profiles
			) {
		super();
		this.films = films;
		this.genres = genres;
		this.people = people;
		this.profiles = profiles;
		this.tvseries = tvSeries;

	}


	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	public List<TvSeries> getTvseries() {
		return tvseries;
	}
	public void setTvseries(List<TvSeries> tvseries) {
		this.tvseries = tvseries;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public List<People> getPeople() {
		return people;
	}
	public void setPeople(List<People> people) {
		this.people = people;
	}
	public List<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}


	private List<Film> films;
	private List<TvSeries> tvseries;
	private List<Genre> genres;
	private List<People> people;
	private List<Profile> profiles;



	public void addFilm(Film film) {
		this.films.add(film);
	}
	public void addTvSeries(TvSeries tvSeries) {
		this.tvseries.add(tvSeries);
	}
	public Map<Integer, Film> getFilmsMap() {
		return this.filmsMap;
	}

	public Map<Integer, TvSeries> getTvSeriesMap() {
		return this.tvSeriesMap;
	}

	public Map<Integer, Genre> getGenreMap() {
		return this.genreMap;
	}

	public Map<Integer, People> getPeopleMap() {
		return this.peopleMap;
	}

	public Map<String, Profile> getProfileMap() {
		return this.profileMap;
	}




	public void makeFilmMap() {
		this.filmsMap = new HashMap<Integer, Film>();
		for(Film film: this.films) {
			this.filmsMap.put((int)film.getFid(), film);
		}

	}
	public void makeTvSeriesMap() {
		this.tvSeriesMap= new HashMap<Integer, TvSeries>();
		for(TvSeries tvseries: this.tvseries) {
			this.tvSeriesMap.put(tvseries.getTid(), tvseries);
		}
	}
	public void makeGenreMap() {
		this.genreMap= new HashMap<Integer, Genre>();
		for(Genre genre: this.genres) {
			this.genreMap.put(genre.getGid(), genre);
		}
	}
	public void makePeopleMap() {
		this.peopleMap= new HashMap<Integer,People>();
		for(People people: this.people) {
			this.peopleMap.put(people.getPid(), people);
		}
	}
	public void makeProfileMap() {
		this.profileMap= new HashMap<String, Profile>();
		for(Profile profile: this.profiles) {
			this.profileMap.put(profile.getName(), profile);
		}
	}
	public void makeMaps() {
		makeFilmMap();
		makePeopleMap();
		makeGenreMap();
		makeTvSeriesMap();
		makeProfileMap();
	}

	@JsonIgnoreProperties
	@JsonIgnore
	private Map<Integer, Film> filmsMap;
	@JsonIgnore
	private Map<Integer, TvSeries> tvSeriesMap;
	@JsonIgnore
	private Map<Integer, Genre> genreMap;
	@JsonIgnore
	private Map<Integer, People> peopleMap;
	@JsonIgnore
	private Map<String, Profile> profileMap;
}
