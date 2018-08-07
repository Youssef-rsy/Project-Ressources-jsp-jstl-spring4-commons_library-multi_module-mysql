package  com.local.ysf.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.local.ysf.Repositories.RessourcesRepositorie;
import  com.local.ysf.entities.Ressources;

@Service
public class RessourceBehaviorImplementation implements RessourcesBehaviore {

	@Autowired
	private RessourcesRepositorie repositorie;

	public List<Ressources> addRessources(Ressources ressource) {
		// TODO Auto-generated method stub
		repositorie.save(ressource);
		return getAllRessources();
	}

	public List<Ressources> getAllRessources() {
		// TODO Auto-generated method stub
		return repositorie.findAll();
	}

	public List<Ressources> updateRessource(Long idRessource, Ressources ressource) {
		// TODO Auto-generated method stub
		Ressources ressources = repositorie.getOne(idRessource);
		ressources = ressource;
		repositorie.saveAndFlush(ressources);
		return getAllRessources();
	}

	public void DeleteRessource(Long idRessource) {
		// TODO Auto-generated method stub
		repositorie.deleteById(idRessource);
	}

	public Ressources getRessource(Long idRessources) {
		// TODO Auto-generated method stub
		Optional<Ressources> optionalRessources = repositorie.findById(idRessources);
		if(optionalRessources.isPresent())
			return optionalRessources.get();
		return null;
	}

}
