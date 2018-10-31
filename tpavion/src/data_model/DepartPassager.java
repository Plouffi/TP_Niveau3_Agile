package data_model;

import java.sql.Date;

public class DepartPassager {
	
    private String numPasseport;
    private int id;
    private Date dateDepart;
    private int numPlace;

    /**
     * Constructeur pour un departPassager
     * @param numPasseport
     * @param id
     * @param dateDepart
     * @param numPlace
     */
    public DepartPassager(String numPasseport, int id, Date dateDepart, int numPlace) {
        this.numPasseport = numPasseport;
        this.id = id;
        this.dateDepart = dateDepart;
        this.numPlace = numPlace;
    }

    /**
     * Getter de le numéro de passeport
     * @return String
     */
    public String getNumPasseport() {
        return numPasseport;
    }

    /**
     * Setter de le numéro de passeport
     * @param numPasseport
     */
    public void setNumPasseport(String numPasseport) {
        this.numPasseport = numPasseport;
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
     * Getter de la date de depart
     * @return
     */
    public Date getDateDepart() {
        return dateDepart;
    }

    /**
     * Setter de la date de depart
     * @param dateDepart
     */
    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    /**
     * Getter du numero de la place
     * @return int
     */
    public int getNumPlace() {
        return numPlace;
    }

    /**
     * Setter du numero de la place
     * @param numPlace
     */
    public void setNumPlace(int numPlace) {
        this.numPlace = numPlace;
    }
}
