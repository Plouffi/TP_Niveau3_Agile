package data_model;

import java.sql.Date;

public class Depart {
	/* id -> id du vol */
	private int id;
	private Date dateDepart;
	
	public Depart(int id,Date dateDepart){
		this.id = id;
		this.dateDepart = dateDepart;
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
}
