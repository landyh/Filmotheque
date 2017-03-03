package com.skalvasociety.skalva.service;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skalvasociety.skalva.bean.Fichier;
import com.skalvasociety.skalva.bean.Film;
import com.skalvasociety.skalva.dao.IFichierDao;
import com.skalvasociety.skalva.tmdbObject.MovieDetails;
import com.skalvasociety.skalva.tmdbObject.SearchMovie;
import com.skalvasociety.skalva.tmdbObject.TMDBRequest;
import com.skalvasociety.skalva.tmdbObject.Video;

@Service("fichierService")
@Transactional
public class FichierService implements IFichierService {
	
	@Autowired
    private IFichierDao dao;
	
	@Autowired
	private IFilmService filmService;

	public Fichier findByID(int id) {		
		return dao.findById(id);
	}

	public List<Fichier> findAllFichiers() {
		return dao.findAllFichiers();
	}
	
	public void saveFichier(Fichier fichier) {
			dao.saveFichier(fichier);		
	}
	
	public Fichier findFichierByChemin (String chemin){
		return dao.findFichierByChemin(chemin);
	}
	
	public boolean isFichierCheminUnique(String chemin) {
		Fichier fichier = findFichierByChemin(chemin);		
		if(fichier == null)
			return true;
		else
			return false;
	}
	
	

	public void majFichier() {		
		String path = "/media/Disque_PI/Film";
		TMDBRequest tmdbRequest = new TMDBRequest();
		List<String> listeFichier = this.listFichierVideo(path);
		for (String chemin : listeFichier) {
			Fichier fichier = new Fichier();
			fichier.setChemin(chemin);
			if(isFichierCheminUnique(fichier.getChemin())){
				saveFichier(fichier);
				try {	
					// Recherche de l'idTMDB sur la bas TMDB
					SearchMovie movie = tmdbRequest.searchMovie(fichier.getChemin());
					if (movie != null){
						Film film = movie.toFilm();	
						if (film != null){
							// Creation de l'entree Film avec son idTMDB 
							film.setFichier(fichier);
							filmService.saveFilm(film);
							
							// Mise à jour du detail du film avec son idTMDB
							MovieDetails movieDetails = tmdbRequest.getMovieByID(film.getIdTMDB());
							if(movieDetails !=  null)
								movieDetails.toFilm(film);
							
							Video video = tmdbRequest.getVideoByID(film.getIdTMDB());
							if(video != null)
								video.toFilm(film);
						}					
					}																
				} catch (IOException e) {			
					e.printStackTrace();
				}
			}			
		}
		try {
			tmdbRequest.getMovieByID(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * Lit les fichiers d'un dossier (ne lit pas dans les sous-dossiers)
	 * @param path
	 * @return Liste des noms de fichiers
	 */
	private List<String> listFichierVideo(String path){		
		List<String> listFichier = new LinkedList<String>();
		File file = new File(path);
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (!files[i].isDirectory()) {
					//TODO: Filtrer sur les types
					//MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();			
					//System.out.println("Ficheir " +files[i].getName() + " - type fichier: " + fileTypeMap.getContentType(files[i].getName()));
					//if(fileTypeMap.getContentType(files[i].getName()).startsWith("video/x")){						
						listFichier.add(files[i].getName());						
					//}
				}
			}
		}   	
		return listFichier;
	}
	


}
