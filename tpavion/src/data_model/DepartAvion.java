package data_model;

import java.sql.Date;

public class DepartAvion {
	/* id -> id de depart */
	private int id;
	private Date dateDepart;
	private String immatriculation;
	private int qteCarburant;
	
	public DepartAvion(int id, Date dateDepart, String immatriculation, int qteCarburant){
		this.id = id;
		this.dateDepart = dateDepart;
		this.immatriculation = immatriculation;
		this.qteCarburant = qteCarburant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getQteCarburant() {
		return qteCarburant;
	}

	public void setQteCarburant(int qteCarburant) {
		this.qteCarburant = qteCarburant;
	}

}
