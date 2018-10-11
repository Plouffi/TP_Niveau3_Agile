package data_model;

import java.math.BigInteger;

public class Passager {

	private int numPasseport;
	private String prenom;
	private String nom;
	private String adresse;
	private BigInteger noTelephone;
	
	public Passager(int numPasseport, String prenom, String nom, String adresse, BigInteger noTelephone) {
		this.numPasseport = numPasseport;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.noTelephone = noTelephone;
	}
	
	public int getNumPasseport() {
		return numPasseport;
	}

	public void setNumPasseport(int numPasseport) {
		this.numPasseport = numPasseport;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public BigInteger getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(BigInteger noTelephone) {
		this.noTelephone = noTelephone;
	}
}
