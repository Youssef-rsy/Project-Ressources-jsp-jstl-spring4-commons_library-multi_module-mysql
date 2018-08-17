package com.local.ysf.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import model.ListIdRressource;
import model.Projets;
import model.ProjetsResponsable;
import model.Ressources;

@Controller
@RequestMapping("RessourcesProjets/projets")
public class ProjetController {

	private List<Projets> listProjet;
	private Projets myProjet;
	private RestTemplate restTemplate;

	@GetMapping(value = "/{id}", produces = "application/json")
	public @ResponseBody Projets getProjet(@PathVariable long id, Model model) throws URISyntaxException {

		restTemplate = new RestTemplate();
		myProjet = new Projets();
		URI uri = new URI("http://localhost:9999/projets/" + id);
		myProjet = restTemplate.getForObject(uri, Projets.class);
		model.addAttribute("Projet", myProjet);

		return myProjet;
	}

	@GetMapping("/delete/{id}")
	public String deleteProjet(@PathVariable long id, Model model) throws URISyntaxException {

		restTemplate = new RestTemplate();
		myProjet = new Projets();
		URI uri = new URI("http://localhost:9999/projets/" + id);
		restTemplate.delete(uri);
		model.addAttribute("listProjets", callGetAllProjet());
		return "projet";
	}

	@GetMapping("")
	public String getALLProjet(Model model) throws URISyntaxException {
		model.addAttribute("listProjets", callGetAllProjet());
		model.addAttribute("listResponsables", callGetAllRessourceResponsable());
		model.addAttribute("listNonResponsables", callGetAllRessourceNotAffected());
		return "projet";
	}

	// @PostMapping("/")
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public String addnewProjets(Model model, @RequestBody Projets projetiN) throws URISyntaxException {

		long responsableId = projetiN.getResponsable();
		restTemplate = new RestTemplate();
		Ressources myReessource = new Ressources();
		URI uri = new URI("http://localhost:9999/ressources/" + responsableId);
		myReessource = restTemplate.getForObject(uri, Ressources.class);
		projetiN.setResponsable(null);

		uri = new URI("http://localhost:9999/projets");
		RestTemplate restTemplate = new RestTemplate();
		Projets result = restTemplate.postForObject(uri,
				new Projets(projetiN.getNom(), projetiN.getDateDebut(), projetiN.getDateFin()), Projets.class);
		uri = new URI("http://localhost:9999/projets/projetsResponsable/" + result.getIdProjet());
		restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		// Data attached to the request.
		HttpEntity<Ressources> requestBody = new HttpEntity(myReessource, headers);
		// Send request with PUT method.
		restTemplate.put(uri, requestBody); //*/
		return "projet";
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
	public String updateProjets(@RequestBody Projets ProjetIn, @PathVariable long id) throws URISyntaxException {

		System.out.println(ProjetIn.toString() + " - id :" + id);

		restTemplate = new RestTemplate();

		URI uri = new URI("http://localhost:9999/projets/" + id + "/");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		RestTemplate restTemplate = new RestTemplate();

		// Data attached to the request.
		HttpEntity<Projets> requestBody = new HttpEntity(ProjetIn, headers);

		// Send request with PUT method.
		restTemplate.put(uri, requestBody); //
		//model.addAttribute("listProjets", callGetAllProjet());
		return "projet";
	}

	public List<ProjetsResponsable> callGetAllProjet() throws URISyntaxException {
		restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:9999/projets/");
		ResponseEntity<ProjetsResponsable[]> responseEntity = restTemplate.getForEntity(uri, ProjetsResponsable[].class);
		ProjetsResponsable[] objects = responseEntity.getBody();
		List<ProjetsResponsable> listProjets = Arrays.asList(objects);
	
		return listProjets;
	}

	public List<Ressources> callGetAllRessourceResponsable() throws URISyntaxException {
		restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:9999/ressources/responsable");
		ResponseEntity<Ressources[]> responseEntity = restTemplate.getForEntity(uri, Ressources[].class);
		Ressources[] objects = responseEntity.getBody();
		List<Ressources> listResssources = Arrays.asList(objects);
		return listResssources;
	}

	public List<Ressources> callGetAllNonRessourceResponsable() throws URISyntaxException {
		restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:9999/ressources/nonResponsable");
		ResponseEntity<Ressources[]> responseEntity = restTemplate.getForEntity(uri, Ressources[].class);
		Ressources[] objects = responseEntity.getBody();
		List<Ressources> listResssources = Arrays.asList(objects);
		return listResssources;
	}

	public List<Ressources> callGetAllRessourceNotAffected() throws URISyntaxException {
		restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:9999/ressources/nonAffectedRessources");
		ResponseEntity<Ressources[]> responseEntity = restTemplate.getForEntity(uri, Ressources[].class);
		Ressources[] objects = responseEntity.getBody();
		List<Ressources> listResssources = Arrays.asList(objects);
		return listResssources;
	}
	@PostMapping("/affecter/{projetid}")
	public void affectation(@PathVariable long projetid , @RequestBody ListIdRressource listRessource) throws URISyntaxException{
		
		URI  uri = new URI("http://localhost:9999/projets/affectRessources/"+projetid );
		System.out.println(uri);
		System.out.println("From presentation listRessource.getLstRessources().size() : "+ listRessource.getLstRessources().size());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		restTemplate = new RestTemplate();
		// Data attached to the request.
	
		HttpEntity<ListIdRressource> requestBody = new HttpEntity<ListIdRressource>(listRessource, headers);

		// Send request with PUT method.
		
		System.out.println("fin");
		restTemplate.put(uri, requestBody);
		System.out.println("fin fin");
	}

}
/*	restTemplate = new RestTemplate();
myProjet = new Projets();
URI uri = new URI("http://localhost:9999/projets/" + projetid);
myProjet = restTemplate.getForObject(uri, Projets.class);

List<Ressources> lstRs= new ArrayList<Ressources>();
for(int i = 0 ; i< listRessource.getLstRessources().size(); i++){
	restTemplate =  new RestTemplate();
	Ressources myReessource = new Ressources();
	 uri =  new URI("http://localhost:9999/ressources/"+listRessource.getLstRessources().get(i));
	myReessource = restTemplate.getForObject(uri, Ressources.class);
	lstRs.add(myReessource);
}//projet affectRessources

myProjet.setCollaborateur(lstRs);
System.out.println("*********************** showing ressources *********************** ");
for(int i=0 ;i<lstRs.size();i++){
		System.out.println(myProjet.getCollaborateur().get(i).toString());
}*/