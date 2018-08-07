package  com.local.ysf.Service;

import java.util.List;

import  com.local.ysf.entities.Ressources;

public interface RessourcesBehaviore {

	public List<Ressources> addRessources(Ressources ressource);
	public List<Ressources> getAllRessources();
	public List<Ressources> updateRessource(Long idRessource , Ressources ressource);
	public void DeleteRessource(Long idRessource);
	public Ressources getRessource(Long idRessources);
	
}
