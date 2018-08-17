package com.local.ysf.Service;

import java.util.ArrayList;
import java.util.List;

import com.local.ysf.entities.Projets;
import com.local.ysf.entities.Ressources;

public class ResosurcesProjetServices {
	
	
	
	private static model.Ressources ressources;
	private static List<model.Ressources> lst;
	
	private static model.Projets modelProjet;
	private static List<model.Projets> listModelProjet;
	
	
	public static model.Ressources matchingDataRessourcesToModel(Ressources res) {
		model.Ressources modelressources = new model.Ressources();
		modelressources.setIdRessouces(res.getIdRessouces());
		modelressources.setNom(res.getNom());
		modelressources.setPrenom(res.getPrenom());
		modelressources.setDateAffectation(res.getDateAffectation());
		//modelressources.setProjet(res.getProjet());
		modelressources.setStatus(res.getStatus());
		return modelressources;
	}

	public static Ressources matchingDataModelToRessources(model.Ressources res) {
		Ressources myRessources = new Ressources();
		myRessources.setIdRessouces(res.getIdRessouces());
		myRessources.setNom(res.getNom());
		myRessources.setPrenom(res.getPrenom());
		myRessources.setDateAffectation(res.getDateAffectation());
		myRessources.setStatus(res.getStatus());
		return myRessources;
	}

	public static List<model.Ressources> matchingListRessources(List<Ressources> list) {

		model.Ressources myRessources = new model.Ressources();
		lst = new ArrayList<model.Ressources>();
		for (Ressources res : list) {
			myRessources = matchingDataRessourcesToModel(res);
			lst.add(myRessources);
		}

		return lst;
	}
	public static model.Projets matchingDataProjetToModel(Projets pj) {
		model.Projets modelProjet = new model.Projets();
		modelProjet.setIdProjet(pj.getIdProjet());
		modelProjet.setDateDebut(pj.getDateDebut());
		modelProjet.setDateFin(pj.getDateFin());
		modelProjet.setNom(pj.getNom());
		if(pj.getCollaborateur()!=null){
			modelProjet.setCollaborateur(matchingListRressourceToModel(pj.getCollaborateur()));
		}
		return modelProjet;
	}
	public static model.ProjetsResponsable matchingDataProjetToModelProjetsResponsable(Projets pj) {
		model.ProjetsResponsable modelProjet = new model.ProjetsResponsable();
		modelProjet.setIdProjet(pj.getIdProjet());
		modelProjet.setDateDebut(pj.getDateDebut());
		modelProjet.setDateFin(pj.getDateFin());
		modelProjet.setNom(pj.getNom());
		if(pj.getResponsable()!=null)
			modelProjet.setResponsable(matchingDataRessourcesToModel(pj.getResponsable()));
		if(pj.getCollaborateur()!=null){
			modelProjet.setCollaborateur(matchingListRressourceToModel(pj.getCollaborateur()));
		}
		return modelProjet;
	}

	public static Projets matchingDataModelToProjet(model.Projets pj) {
		Projets myProjet = new Projets();
		myProjet.setIdProjet(pj.getIdProjet());
		myProjet.setDateDebut(pj.getDateDebut());
		myProjet.setDateFin(pj.getDateFin());
		myProjet.setNom(pj.getNom());
		//myProjet.setResponsable(pj.getResponsable());
		//myProjet.setCollaborateur(pj.getCollaborateur());
		return myProjet;
	}
	public static List<model.Projets> matchingListProjetsToModel(List<Projets> list) {

		model.Projets myProjet = new model.Projets();
		List<model.Projets>listModelProjet = new ArrayList<model.Projets>();
		for (Projets pj : list) {
			myProjet = matchingDataProjetToModel(pj);
			listModelProjet.add(myProjet);
		}

		return listModelProjet;
	}
	public static List<model.Ressources> matchingListRressourceToModel(List<Ressources> list) {

		model.Ressources myRessource = new model.Ressources();
		List<model.Ressources>listModelRessources= new ArrayList<model.Ressources>();
		for (Ressources rs : list) {
			myRessource = matchingDataRessourcesToModel(rs);
			listModelRessources.add(myRessource);
		}

		return listModelRessources;
	}
	public static List<model.Projets> matchingListProjets(List<Projets> list) {

		model.Projets myProjet = new model.Projets();
		listModelProjet = new ArrayList<model.Projets>();
		for (Projets pj : list) {
			myProjet = matchingDataProjetToModel(pj);
			listModelProjet.add(myProjet);
		}

		return listModelProjet;
	}
	public static List<model.ProjetsResponsable> matchingListProjetsResponsable(List<Projets> list) {

		model.ProjetsResponsable myProjet = new model.ProjetsResponsable();
		List<model.ProjetsResponsable> listModelProjet = new ArrayList<model.ProjetsResponsable>();
		for (Projets pj : list) {
			myProjet = matchingDataProjetToModelProjetsResponsable(pj);
			listModelProjet.add(myProjet);
		}

		return listModelProjet;
	}
}
