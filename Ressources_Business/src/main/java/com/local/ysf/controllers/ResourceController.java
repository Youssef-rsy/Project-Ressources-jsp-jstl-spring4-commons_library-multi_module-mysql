package com.local.ysf.controllers;

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

	/*@GetMapping
	public List<model.Ressources> getAllRessources() {
		return allRessources();
	}

	@PostMapping
	public List<model.Ressources> addNewRessource(@RequestBody model.Ressources ressource) {
		lst = ressourceBehavior.addRessources(ressource);
		return lst;
	}

	@DeleteMapping("/{id}")
	public List<model.Ressources> deleteRessources(@PathVariable long id) {
		ressourceBehavior.DeleteRessource(id);
		return allRessources();
	}

	@PutMapping("/{id}")
	public List<model.Ressources> updateeRessources(@PathVariable long id, @RequestBody model.Ressources ressource) {
		System.out.println("->" + ressource);
		ressourceBehavior.updateRessource(id, ressource);
		return allRessources();
	}
*/
	@GetMapping("/{id}")
	public model.Ressources getRessource(@PathVariable long id) {
		ressources = matchingData( ressourceBehavior.getRessource(id));
		return ressources;
	}

	/*public List<model.Ressources> allRessources() {
		lst = ressourceBehavior.getAllRessources();
		return lst;
	}*/
	
	public model.Ressources matchingData(Ressources res){
		ressources.setIdRessouces(res.getIdRessouces());
		ressources.setNom(res.getNom());
		ressource.setPrenom(res.getPrenom());
		ressource.setDateAffectation(res.getDateAffectation());
		ressource.setProjet(res.getProjet());
		ressource.setStatus(res.getStatus());
		return ressources;
	}

}
