package data_model;

import java.math.BigInteger;

public class Passager extends Personne{

	private String numPasseport;

	/**
	 * Constructeur pour un passager
	 * @param numPasseport
	 * @param prenom
	 * @param nom
	 * @param adresse
	 * @param noTelephone
	 */
	public Passager(String numPasseport, String prenom, String nom, String adresse, BigInteger noTelephone) {
		super(prenom,nom,adresse,noTelephone);
		this.numPasseport = numPasseport;
	}

	/**
	 * Getter du numéro de passeport
	 * @return String
	 */
	public String getNumPasseport() {
		return numPasseport;
	}

	/**
	 * Setter du numero de passeport
	 * @param numPasseport
	 */
	public void setNumPasseport(String numPasseport) {
		this.numPasseport = numPasseport;
	}
}
