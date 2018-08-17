package com.local.ysf.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.ysf.Service.ProjetsBehavior;
import com.local.ysf.Service.ResosurcesProjetServices;
import com.local.ysf.Service.RessourcesBehaviore;
import com.local.ysf.entities.Projets;

import model.ListIdRressource;
import model.Ressources;

@RestController
@RequestMapping("/projets")
public class ProjetController {

	@Autowired
	private ProjetsBehavior projetbahavior;
	@Autowired
	private RessourcesBehaviore rsbehavior;
	
	private model.Projets modelProjet;
	private List<model.Projets> listModelProjet;
	
	
	@PostMapping("")
	public model.Projets addProjet(@RequestBody model.Projets mProjet) {
		// TODO Auto-generated method stub
		Projets pj  = projetbahavior.addProjets(ResosurcesProjetServices.matchingDataModelToProjet(mProjet));
		return ResosurcesProjetServices.matchingDataProjetToModel(pj) ;
	}
	
	@DeleteMapping("/{idProjet}")
	public List<model.Projets> deleteProjet(@PathVariable long idProjet) {
		// TODO Auto-generated method stub
		projetbahavior.DeleteProjet(idProjet);
		return gettAllProjet();
	}
	
	@PutMapping("/{idProjet}")
	public List<model.Projets> updateProjet(@PathVariable long idProjet , @RequestBody model.Projets modelPejet ) {
		// TODO Auto-generated method stub
		System.out.println("from constroller idProjet :"+idProjet);
		System.out.println("from constroller modelPejet :"+modelPejet.toString());
		
		projetbahavior.updateProjet(idProjet, ResosurcesProjetServices.matchingDataModelToProjet(modelPejet));
		return gettAllProjet();
	}
	@GetMapping("/{idProjet}")
	public model.Projets getProjet(@PathVariable long idProjet) {
		// TODO Auto-generated method stub
		return ResosurcesProjetServices.matchingDataProjetToModel(projetbahavior.getProjet(idProjet));
	}
	@GetMapping
	public List<model.ProjetsResponsable> getProjets() {
		// TODO Auto-generated method stub
		return gettAllProjetRessources();
	}
	
	public List<model.Projets> gettAllProjet(){
		return ResosurcesProjetServices.matchingListProjets(projetbahavior.getAllProjets());
	}
	public List<model.ProjetsResponsable> gettAllProjetRessources(){
		return ResosurcesProjetServices.matchingListProjetsResponsable(projetbahavior.getAllProjets());
	}
	@PutMapping("/projetsResponsable/{idProjet}")
	public void getProjet(@PathVariable long idProjet , @RequestBody Ressources responsable) {
		// TODO Auto-generated method stub
				System.out.println(" ---------------------> i'm here" +idProjet );
				Projets pj = projetbahavior.getProjet(idProjet);
				System.out.println(pj.getNom());
				//System.out.println("*"+ResosurcesProjetServices.matchingDataModelToRessources(responsable).toString());
				try {
					pj.setResponsable(ResosurcesProjetServices.matchingDataModelToRessources(responsable));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("idProjet :"+ idProjet +"  pj:  "+pj.getResponsable().toString());
				projetbahavior.updateProjet(idProjet, pj);
				System.out.println("responsable : -> "+projetbahavior.getProjet(idProjet).getResponsable());
	}
	
	@PutMapping("/affectRessources/{projetid}")
	public void affectation( @PathVariable long projetid , @RequestBody ListIdRressource listRessource){
		System.out.println("*/*/*/*/*/*/*/*/*/*");

		System.out.println(projetid);
		System.out.println(" listRessource.getLstRessources().size() : "+ listRessource.getLstRessources().size());
		Projets pj = projetbahavior.getProjet(projetid);
		List<com.local.ysf.entities.Ressources> lstr = new ArrayList<>();
		for (Long idrs : listRessource.getLstRessources()) {
			lstr.add(rsbehavior.getRessource(idrs));
		}
		System.out.println(lstr.size());
		pj.setCollaborateur(lstr);
		System.out.println(pj.getCollaborateur().get(0).getNom());
		
		projetbahavior.updateProjet(projetid, pj);
		System.out.println("*/*/*/*/*/*/*/*/*/*");
	}
	
	
}
