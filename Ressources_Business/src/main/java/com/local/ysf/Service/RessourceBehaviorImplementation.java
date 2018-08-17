package  com.local.ysf.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.local.ysf.Repositories.RessourcesRepositorie;
import com.local.ysf.entities.Ressources;

import enummeration.Status;

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
		Ressources ressources = getRessource(idRessource);
		ressources.setDateAffectation(ressource.getDateAffectation());
		ressources.setNom(ressource.getNom());
		ressources.setPrenom(ressource.getPrenom());
		ressources.setStatus(ressource.getStatus());
		System.out.println("---------------->"+ressources.toString());
		repositorie.save(ressources);
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

	@Override
	public List<Ressources> getResponsableRessource() {
		// TODO Auto-generated method stub
		return repositorie.findByStatus(Status.Responsable);
	}

	@Override
	public List<Ressources> getNonResponsableRessource() {
		// TODO Auto-generated method stub
		return repositorie.findByStatusIsNot(Status.Responsable);
	}

	@Override
	public List<Ressources> getNonResponsableRessourceNotAffected() {
		// TODO Auto-generated method stub
		return repositorie.findByStatusIsNot(Status.Responsable);
	}

}
