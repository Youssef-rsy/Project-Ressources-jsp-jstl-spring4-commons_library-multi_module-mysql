package com.local.ysf.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.local.ysf.Repositories.ProjetsRepositorie;
import  com.local.ysf.entities.Projets;

@Service
public class ProjetBehaviorImplementation implements ProjetsBehavior {

	@Autowired
	private ProjetsRepositorie repositorie;
	
	
	public List<Projets> addProjets(Projets projet) {
		// TODO Auto-generated method stub
		repositorie.save(projet);
		return getAllProjets();
	}

	public List<Projets> getAllProjets() {
		// TODO Auto-generated method stub
		return repositorie.findAll();
	}

	public List<Projets> updateProjet(Long idProjet, Projets projet) {
		// TODO Auto-generated method stub
		Projets projets =getProjet(idProjet);
		projets = projet;
		repositorie.saveAndFlush(projets);
		return getAllProjets();
	}

	public void DeleteProjet(Long idProjet) {
		// TODO Auto-generated method stub
		repositorie.deleteById(idProjet);;
	}

	public Projets getProjet(Long idProjets) {
		// TODO Auto-generated method stub
		Optional<Projets> optionalProjet = repositorie.findById(idProjets);
		if(optionalProjet.isPresent())
			return optionalProjet.get();
		
		return null;
	}

}
