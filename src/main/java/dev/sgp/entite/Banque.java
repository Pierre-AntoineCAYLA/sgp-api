package dev.sgp.entite;

import javax.persistence.Embeddable;

@Embeddable
public class Banque {

	private String nombanque;
	private String iban;
	private String bic;

	public Banque() {
		super();
	}

	public String getNom() {
		return nombanque;
	}

	public void setNom(String nom) {
		this.nombanque = nom;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
