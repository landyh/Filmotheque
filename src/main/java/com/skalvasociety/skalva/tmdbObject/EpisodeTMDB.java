package com.skalvasociety.skalva.tmdbObject;

import java.util.List;

public class EpisodeTMDB {
	private String air_date;
	private List<Crew> crew;
	private Integer episode_number;
	private List<GuestStars> guest_stars;
	private String name;
	private String overview;
	private Integer id;
	private String  production_code;
	private Integer season_number;
	private String still_path;
	private Double vote_average;
	private Integer vote_count;
	public String getAir_date() {
		return air_date;
	}
	public void setAir_date(String air_date) {
		this.air_date = air_date;
	}
	public List<Crew> getCrew() {
		return crew;
	}
	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}
	public Integer getEpisode_number() {
		return episode_number;
	}
	public void setEpisode_number(Integer episode_number) {
		this.episode_number = episode_number;
	}
	public List<GuestStars> getGuest_stars() {
		return guest_stars;
	}
	public void setGuest_stars(List<GuestStars> guest_stars) {
		this.guest_stars = guest_stars;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduction_code() {
		return production_code;
	}
	public void setProduction_code(String production_code) {
		this.production_code = production_code;
	}
	public Integer getSeason_number() {
		return season_number;
	}
	public void setSeason_number(Integer season_number) {
		this.season_number = season_number;
	}
	public String getStill_path() {
		return still_path;
	}
	public void setStill_path(String still_path) {
		this.still_path = still_path;
	}
	public Double getVote_average() {
		return vote_average;
	}
	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}
	public Integer getVote_count() {
		return vote_count;
	}
	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
	
	
}
