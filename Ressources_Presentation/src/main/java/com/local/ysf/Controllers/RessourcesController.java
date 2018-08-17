package com.local.ysf.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import model.Ressources;

@CrossOrigin("*")
@Controller
@RequestMapping("RessourcesProjets/ressource/")
public class RessourcesController {

	private List<Ressources> listRessource;
	private Ressources myReessource;
	private  RestTemplate restTemplate;
	
	@GetMapping(value="/{id}" , produces="application/json")
	public @ResponseBody Ressources getRessource(@PathVariable long id, Model model) throws URISyntaxException{
		
		restTemplate =  new RestTemplate();
		myReessource = new Ressources();
		URI uri =  new URI("http://localhost:9999/ressources/"+id);
		myReessource = restTemplate.getForObject(uri, Ressources.class);
		model.addAttribute("ressource", myReessource);
		
		return myReessource;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRessource(@PathVariable long id , Model model) throws URISyntaxException{
		
		restTemplate =  new RestTemplate();
		myReessource = new Ressources();
		URI uri =  new URI("http://localhost:9999/ressources/"+id);
		restTemplate.delete(uri);
		model.addAttribute("listResssources", callGetAllRessource());
		return "index";
	}
	
	
	
	
	@GetMapping("")
	public String getALLRessource( Model model) throws URISyntaxException{
		
		model.addAttribute("listResssources", callGetAllRessource());
		return "index";
	}
	
	//@PostMapping("/")
	@RequestMapping(method=RequestMethod.POST , value="/")
	public String addnewRessources(Model model , @RequestBody Ressources ressourceiN) throws URISyntaxException{
		System.out.println(ressourceiN.toString());
		restTemplate =  new RestTemplate();
		URI uri =  new URI("http://localhost:9999/ressources/");
		RestTemplate restTemplate = new RestTemplate();
        // Data attached to the request.
        HttpEntity<Ressources> requestBody = new HttpEntity(ressourceiN);
        // Send request with POST method.
        ResponseEntity<Ressources[]> result 
            = restTemplate.postForEntity(uri, requestBody, Ressources[].class);
        // Code = 200.
        if (result.getStatusCode() == HttpStatus.OK) {
        	   Ressources[] objects = result.getBody();
        	   List<Ressources> listResssources = Arrays.asList(objects);
               System.out.println("Status code:" + result.getStatusCode());
               model.addAttribute("listResssources", callGetAllRessource());
        }
		
		return "index";
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST , value="/update/{id}")
	public String updateRessources(@RequestBody Ressources ressourceIn , @PathVariable long id) throws URISyntaxException{
		
		System.out.println(ressourceIn.toString() +"  - id :"+id);
		
	 	restTemplate =  new RestTemplate();
		URI uri =  new URI("http://localhost:9999/ressources/"+id+"/");
		
		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	 
	     RestTemplate restTemplate = new RestTemplate();
	 
	        // Data attached to the request.
	        HttpEntity<Ressources> requestBody = new HttpEntity(ressourceIn, headers);
	 
	        // Send request with PUT method.
	        restTemplate.put(uri, requestBody);
		
		//model.addAttribute("listResssources", callGetAllRessource());
		return "index";
	}
	
	/* uri =  new URI("http://localhost:9999/ressources/responsable");
		 responseEntity = restTemplate.getForEntity(uri, Ressources[].class);
		 objects = responseEntity.getBody();
		listResssources = Arrays.asList(objects);
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
