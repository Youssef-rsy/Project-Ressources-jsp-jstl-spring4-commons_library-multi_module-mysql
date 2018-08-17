package  com.local.ysf.Service;

import java.util.List;

import  com.local.ysf.entities.Projets;

import model.Ressources;

public interface ProjetsBehavior {
	public Projets addProjets(Projets projet);
	public List<Projets> getAllProjets();
	public List<Projets> updateProjet(Long idProjet , Projets projet);
	public void DeleteProjet(Long idProjet);
	public Projets getProjet(Long idProjets);
	public void updateProject(Long idp ,Projets projet);
}
