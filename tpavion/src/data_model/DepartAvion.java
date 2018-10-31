package data_model;

import java.sql.Date;

public class DepartAvion {
    /* id -> id de depart */
    private int id;
    private Date dateDepart;
    private String immatriculation;
    private int qteCarburant;

    /**
     * Constructeur pour un DepartAvion
     * @param id
     * @param dateDepart
     * @param immatriculation
     * @param qteCarburant
     */
    public DepartAvion(int id, Date dateDepart, String immatriculation, int qteCarburant){
        this.id = id;
        this.dateDepart = dateDepart;
        this.immatriculation = immatriculation;
        this.qteCarburant = qteCarburant;
    }

    /**
     * Getter de l'id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de l'id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de la date 
     * @return Date
     */
    public Date getDateDepart() {
        return dateDepart;
    }

    /**
     * Setter de la date
     * @param dateDepart
     */
    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
     * Getter de l'immatriculation
     * @return String
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Setter de l'immatriculation
     * @param immatriculation
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
     * Getter de la quantite de carburant
     * @return int
     */
    public int getQteCarburant() {
        return qteCarburant;
    }

    /**
     * Setter de la quantite de carburant
     * @param qteCarburant
     */
    public void setQteCarburant(int qteCarburant) {
        this.qteCarburant = qteCarburant;
    }

}
