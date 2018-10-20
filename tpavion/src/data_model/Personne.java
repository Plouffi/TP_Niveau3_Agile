package data_model;

import java.math.BigInteger;

public class Personne {


    private String prenom;
    private String nom;
    private String adresse;
    private BigInteger noTelephone;

    public Personne(String prenom, String nom, String adresse, BigInteger noTelephone) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.noTelephone = noTelephone;
    }

    public Personne(){}

    /**
     * Getter du pr�nom
     * @return String
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter du pr�nom
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter du nom
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de l'adresse
     * @return String
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Setter de l'adresse
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Getter du numero de telephone
     * @return BigInteger
     */
    public BigInteger getNoTelephone() {
        return noTelephone;
    }

    /**
     * Setter du num�ro de telephone
     * @param noTelephone
     */
    public void setNoTelephone(BigInteger noTelephone) {
        this.noTelephone = noTelephone;
    }

}
