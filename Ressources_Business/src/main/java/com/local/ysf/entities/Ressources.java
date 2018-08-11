package  com.local.ysf.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Ressources {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRessouces;
	private String nom;
	private String prenom;
	private Date dateAffectation;
	private String status;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Projets projet;

	public Ressources(String nom, String prenom, Date dateAffectation, String status, Projets projet) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateAffectation = dateAffectation;
		this.status = status;
		this.projet = projet;
	}

	public Ressources(Long idRessouces, String nom, String prenom, Date dateAffectation, String status,
			Projets projet) {
		super();
		this.idRessouces = idRessouces;
		this.nom = nom;
		this.prenom = prenom;
		this.dateAffectation = dateAffectation;
		this.status = status;
		this.projet = projet;
	}
	public Ressources( String nom, String prenom, Date dateAffectation, String status
			) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateAffectation = dateAffectation;
		this.status = status;
	}

	public Projets getProjet() {
		return projet;
	}

	public void setProjet(Projets projet) {
		this.projet = projet;
	}

	public Ressources() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getIdRessouces() {
		return idRessouces;
	}

	public void setIdRessouces(Long idRessouces) {
		this.idRessouces = idRessouces;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ressources [idRessouces=" + idRessouces + ", nom=" + nom + ", prenom=" + prenom + ", dateAffectation="
				+ dateAffectation + ", status=" + status + ", projet=" + projet + "]";
	}


	

}
