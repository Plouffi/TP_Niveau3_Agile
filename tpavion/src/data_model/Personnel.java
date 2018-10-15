package data_model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Personnel {
	
	private int id;
	private String prenom;
	private String nom;
	private String adresse;
	private BigInteger noTelephone;
	private String motDePasse; 
	private Role role;
	
	public Personnel(String prenom, String nom, String adresse, BigInteger noTelephone, String motDePasse,
			Role role) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.noTelephone = noTelephone;
		this.motDePasse = motDePasse;
		this.role = role;
	}
	
	public Personnel(int id, String prenom, String nom, String adresse, BigInteger noTelephone, String motDePasse,
			Role role) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.noTelephone = noTelephone;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public Personnel(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
