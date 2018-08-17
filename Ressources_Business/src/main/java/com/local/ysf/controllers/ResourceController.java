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

import com.local.ysf.Service.ResosurcesProjetServices;
import com.local.ysf.Service.RessourcesBehaviore;
import com.local.ysf.entities.Ressources;

@RestController
@RequestMapping("/ressources")
public class ResourceController {

	@Autowired
	private RessourcesBehaviore ressourceBehavior;

	private Ressources ressource;

	private model.Ressources ressources;
	
	private List<model.Ressources> lst;

	
	@GetMapping
	public List<model.Ressources> getAllRessources() {
		System.out.println("///////////////////////////"+getNonResponsables().size());
		return allRessources();
	}

	@PostMapping
	public List<model.Ressources> addNewRessource(@RequestBody model.Ressources ressource) {
		ressourceBehavior.addRessources(ResosurcesProjetServices.matchingDataModelToRessources(ressource));
		return allRessources();
	}

	@DeleteMapping("/{id}")
	public List<model.Ressources>deleteRessources(@PathVariable long id) {
		ressourceBehavior.DeleteRessource(id);
		return allRessources();
	}

	@PutMapping("/{id}")
	public List<model.Ressources> updateeRessources(@PathVariable long id, @RequestBody model.Ressources ressource) {
		System.out.println("->" + ressource);
		ressourceBehavior.updateRessource(id, ResosurcesProjetServices.matchingDataModelToRessources(ressource));
		return allRessources();
	}

	@GetMapping("/{id}")
	public model.Ressources getRessource(@PathVariable long id) {
		ressources = ResosurcesProjetServices.matchingDataRessourcesToModel(ressourceBehavior.getRessource(id));
		System.out.println(ressources.toString());
		return ressources;
	}

	public List<model.Ressources> allRessources() {
		lst = ResosurcesProjetServices.matchingListRessources(ressourceBehavior.getAllRessources());
		return lst;
	}
	@GetMapping("/responsable")
	public List<model.Ressources> getResponsables(){
		lst = ResosurcesProjetServices.matchingListRessources(ressourceBehavior.getResponsableRessource());
		return lst;
	}
	@GetMapping("/nonResponsable")
	public List<model.Ressources> getNonResponsables(){
		lst = ResosurcesProjetServices.matchingListRessources(ressourceBehavior.getNonResponsableRessource());
		return lst;
	}
	@GetMapping("/nonAffectedRessources")
	public List<model.Ressources> getNonAffectedRessources(){
		lst = ResosurcesProjetServices.matchingListRessources(ressourceBehavior.getNonResponsableRessourceNotAffected());
		return lst;
	}	
	
	

}
