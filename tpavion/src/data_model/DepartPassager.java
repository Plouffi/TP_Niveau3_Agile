package data_model;

import java.sql.Date;

public class DepartPassager {
	
	private int numPasseport;
	private int id;
	private Date dateDepart;
	private int numPlace;

	public DepartPassager(int numPasseport, int id, Date dateDepart, int numPlace) {
		this.numPasseport = numPasseport;
		this.id = id;
		this.dateDepart = dateDepart;
		this.numPlace = numPlace;
	}
	
	public int getNumPasseport() {
		return numPasseport;
	}

	public void setNumPasseport(int numPasseport) {
		this.numPasseport = numPasseport;
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

	public int getNumPlace() {
		return numPlace;
	}

	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}

}
