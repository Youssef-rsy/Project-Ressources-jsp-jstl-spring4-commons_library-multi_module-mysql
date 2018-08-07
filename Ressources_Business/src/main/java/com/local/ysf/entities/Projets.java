package  com.local.ysf.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Projets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProjet;
	private String nom;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Ressources responsable;
	private Date dateDebut;
	private Date dateFin;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ressources> collaborateur;
	public Projets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projets(String nom, Ressources responsable, Date dateDebut, Date dateFin, List<Ressources> collaborateur) {
		super();
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.collaborateur = collaborateur;
	}
	public Projets(Long idProjet, String nom, Ressources responsable, Date dateDebut, Date dateFin,
			List<Ressources> collaborateur) {
		super();
		this.idProjet = idProjet;
		this.nom = nom;
		this.responsable = responsable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.collaborateur = collaborateur;
	}
	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Ressources getResponsable() {
		return responsable;
	}
	public void setResponsable(Ressources responsable) {
		this.responsable = responsable;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public List<Ressources> getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(List<Ressources> collaborateur) {
		this.collaborateur = collaborateur;
	}
	
	
	
	
	
	
}
