package  com.local.ysf.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import  com.local.ysf.Repositories.ProjetsRepositorie;
import com.local.ysf. Repositories.RessourcesRepositorie;
import  com.local.ysf.entities.Projets;
import  com.local.ysf.entities.Ressources;

import ch.qos.logback.classic.net.SyslogAppender;
import enummeration.Status;
@Component
public class DataSeed {

	@Autowired
	private RessourcesRepositorie repositorie;
	
	@Autowired
	private ProjetsRepositorie pjRepositories;

	@PostConstruct
	public void dataRessources(){
		
		List<Ressources> lst = new ArrayList<Ressources>();
		lst.add(new Ressources("rossamy", "youssef", new Date(), Status.Developper));
		lst.add(new Ressources("jamoure", "youssef", new Date(), Status.Developper));
		lst.add(new Ressources("hadi alaoui", "abdelhakim", new Date(), Status.Developper));
		lst.add( new Ressources("chalih", "hajar", new Date(), Status.Developper));
		lst.add(new Ressources("Hind", "sahih", new Date(), Status.Responsable));
		lst.add(new Ressources("MALAK ", "SAHIH", new Date(), Status.Testeur));
		
		System.out.println("ADDING DATA");
		//lst.forEach(ressource -> System.out.println(ressource));
		
		
		lst.forEach(ressource -> repositorie.save(ressource));
		
		
	}
	
	//@PostConstruct
	public void dataProjets(){
		
		List<Projets> lst = new ArrayList<Projets>();
		lst.add(new Projets("project 1", null, new Date(), new Date(), null));
		lst.add(new Projets("project 2", null, new Date(), new Date(), null));
		lst.add(new Projets("project 3", null, new Date(), new Date(), null));
		lst.add(new Projets("project 4", null, new Date(), new Date(), null));
		lst.add(new Projets("project 5", null, new Date(), new Date(), null));
		lst.add(new Projets("project 6", null, new Date(), new Date(), null));
		
		//lst.forEach(projet -> pjRepositories.save(projet));
		
		
	}
	
}
