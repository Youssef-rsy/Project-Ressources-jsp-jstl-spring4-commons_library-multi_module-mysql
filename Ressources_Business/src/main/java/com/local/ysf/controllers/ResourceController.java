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

import  com.local.ysf.Service.RessourcesBehaviore;
import  com.local.ysf.entities.Ressources;

@RestController
@RequestMapping("/ressources")
public class ResourceController {
	
	@Autowired
	private RessourcesBehaviore ressourceBehavior;
	
	private Ressources ressource;
	
	@GetMapping
	public List<Ressources> getAllRessources(){
		return allRessources();
	}
	
	@PostMapping
	public List<Ressources> addNewRessource(@RequestBody Ressources ressource){
		ressourceBehavior.addRessources(ressource);
		return allRessources();
	}
	
	@DeleteMapping("/{id}")
	public List<Ressources> deleteRessources(@PathVariable long id){
		ressourceBehavior.DeleteRessource(id);
		return allRessources();
	}
	
	@PutMapping("/{id}")
	public List<Ressources> updateeRessources(@PathVariable long id , @RequestBody Ressources ressource){
		System.out.println(ressource.toString());
		ressourceBehavior.updateRessource(id, ressource);
		return allRessources();
	}
	@GetMapping("/{id}")
	public Ressources getRessource(@PathVariable long id){
		ressource = ressourceBehavior.getRessource(id);
		return ressource;
	}
	
	public List<Ressources> allRessources(){
		return ressourceBehavior.getAllRessources();
	}

}
