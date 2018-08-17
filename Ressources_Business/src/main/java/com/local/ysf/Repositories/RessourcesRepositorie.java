package  com.local.ysf.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.ysf.entities.Ressources;

import enummeration.Status;


public interface RessourcesRepositorie  extends JpaRepository<Ressources, Long>{

	public List<Ressources> findByStatus(Status status);
	//public List<Ressources> findByStatusAnd(Status status);
	public List<Ressources> findByStatusIsNot(Status status);
	
}
