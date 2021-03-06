package com.skalvasociety.skalva.bean;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SAISON")
@PrimaryKeyJoinColumn(name = "id")
public class Saison extends MediaTMDB {	
	private int numero;	
	private Serie serie;
	private List<Episode> episodes = new LinkedList<Episode>();
	

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSerie", nullable = false)
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}	

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saison")
	public List<Episode> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
}
