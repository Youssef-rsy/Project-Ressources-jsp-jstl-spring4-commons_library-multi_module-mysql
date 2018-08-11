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

@RestController
@RequestMapping("/projets")
public class ProjetController {

	@Autowired
	private ProjetsBehavior projetbahavior;
	
	private model.Projets modelProjet;
	private List<model.Projets> listModelProjet;
	
	
	@PostMapping("")
	public List<model.Projets> addProjet(@RequestBody model.Projets mProjet) {
		// TODO Auto-generated method stub
		projetbahavior.addProjets(ResosurcesProjetServices.matchingDataModelToProjet(mProjet));
		return gettAllProjet();
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
		projetbahavior.updateProjet(idProjet, ResosurcesProjetServices.matchingDataModelToProjet(modelPejet));
		return gettAllProjet();
	}
	@GetMapping("/{idProjet}")
	public model.Projets getProjet(@PathVariable long idProjet) {
		// TODO Auto-generated method stub
		return ResosurcesProjetServices.matchingDataProjetToModel(projetbahavior.getProjet(idProjet));
	}
	@GetMapping
	public List<model.Projets> getProjets() {
		// TODO Auto-generated method stub
		return gettAllProjet();
	}
	
	public List<model.Projets> gettAllProjet(){
		return ResosurcesProjetServices.matchingListProjets(projetbahavior.getAllProjets());
	}
	
	
	
	
}
