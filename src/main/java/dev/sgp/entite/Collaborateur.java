package dev.sgp.entite;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COLLABORATEURS")
public class Collaborateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;
	@ManyToOne
	Departements departements;
	@Column(name = "MATRICULE")
	String matricule;
	@Column(name = "NOM")
	String nom;
	@Column(name = "PRENOM")
	String prenom;
	@Embedded
	Banque banque;

	public Collaborateur() {

	}

	public Collaborateur(Integer id, Departements departements, String matricule, String nom, String prenom,
			Banque banque) {
		super();
		this.id = id;
		this.departements = departements;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.banque = banque;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Departements getDepartements() {
		return departements;
	}

	public void setDepartements(Departements departements) {
		this.departements = departements;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

}
