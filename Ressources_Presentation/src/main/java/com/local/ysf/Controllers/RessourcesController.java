package com.local.ysf.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import model.Ressources;


@Controller
@RequestMapping("RessourcesProjets/ressource/")
public class RessourcesController {

	private List<Ressources> listRessource;
	private Ressources myReessource;
	private  RestTemplate restTemplate;
	@Value("${basedir}")
	private String basedir;
	
	@GetMapping("/{id}")
	public Ressources getRessource(@PathVariable long id, Model model) throws URISyntaxException{
		
		restTemplate =  new RestTemplate();
		myReessource = new Ressources();
		URI uri =  new URI("http://localhost:9999/ressources/"+id);
		myReessource = restTemplate.getForObject(uri, Ressources.class);
		//model.addAttribute("ressource", myReessource);
		
		return myReessource;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRessource(@PathVariable long id , Model model) throws URISyntaxException{
		
		restTemplate =  new RestTemplate();
		myReessource = new Ressources();
		URI uri =  new URI("http://localhost:9999/ressources/"+id);
		restTemplate.delete(uri);
		
		model.addAttribute("listResssources", callGetAllRessource());
		return "home";
	}
	
	
	
	
	@GetMapping("")
	public String getALLRessource( Model model) throws URISyntaxException{
		
		model.addAttribute("listResssources", callGetAllRessource());
		return "home";
	}
	
	@PostMapping
	public String addnewRessources(Model model , @RequestBody Ressources ressourceiN) throws URISyntaxException{
		System.out.println(ressourceiN.toString());
		restTemplate =  new RestTemplate();
		URI uri =  new URI("http://localhost:9999/ressources/");
		HttpEntity<Ressources> request = new HttpEntity(ressourceiN);
		Ressources ressource = restTemplate.postForObject(uri, request, Ressources.class);
		System.out.println(ressource.toString());
		
		model.addAttribute("listResssources", callGetAllRessource());
		return "home";
	}
	
	
	
	@PutMapping
	public String updateRessources(Model model , @RequestBody Ressources ressourceIn) throws URISyntaxException{
		restTemplate =  new RestTemplate();
		URI uri =  new URI("http://localhost:9999/ressources/");
		HttpEntity<Ressources> request = new HttpEntity(ressourceIn);
		ResponseEntity<Ressources> response = restTemplate
				  .exchange(uri, HttpMethod.POST, request, Ressources.class);
		
		model.addAttribute("listResssources", callGetAllRessource());
		return "home";
	}
	/*public List<Ressources> addnewRessources(@RequestBody Ressources ressource){
		restTemplate =  new RestTemplate();
		URI uri =  new URI("http://localhost:9999:projets/")
		restTemplate.getForObject(url, responseType)
		return listRessource;
	}*/
	
	
	public List<Ressources> callGetAllRessource() throws URISyntaxException{
		restTemplate =  new RestTemplate();
		URI uri =  new URI("http://localhost:9999/ressources/");
		ResponseEntity<Ressources[]> responseEntity = restTemplate.getForEntity(uri, Ressources[].class);
		Ressources[] objects = responseEntity.getBody();
		List<Ressources> listResssources = Arrays.asList(objects);
		return listResssources;
	}
	
	
}
