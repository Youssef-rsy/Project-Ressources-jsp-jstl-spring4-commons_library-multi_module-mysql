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
	
	
	public Projets addProjets(Projets projet) {
		// TODO Auto-generated method stub
		return repositorie.save(projet);
	}

	public List<Projets> getAllProjets() {
		// TODO Auto-generated method stub
		return repositorie.findAll();
	}

	public List<Projets> updateProjet(Long idProjet, Projets projet) {
		// TODO Auto-generated method stub
		
		Projets projets = getProjet(idProjet);
		projets.setNom(projet.getNom());
		System.out.println(projets.getNom());
		projets.setDateDebut(projet.getDateDebut());
		System.out.println(projet.getDateDebut());
		projets.setDateFin(projet.getDateFin());
		System.out.println(projet.getDateFin());
		projets.setCollaborateur(projet.getCollaborateur());
		System.out.println(projet.getCollaborateur().size());
		projets.setResponsable(projet.getResponsable());
		System.out.println(projet.getResponsable());
		projets = repositorie.save(projets);
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
		
		System.out.println("optionalProjet :"+optionalProjet.get().getNom());
		return null;
	}

	@Override
	public void updateProject(Long idp, Projets projet) {
		// TODO Auto-generated method stub
		
		
		
	}

}
