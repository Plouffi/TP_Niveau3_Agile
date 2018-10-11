package data_model;

import java.sql.Time;

public class TempsVolType {

	private int id;
	private int type;
	private Time nombreHeure;
	
	public TempsVolType(int id, int type, Time nombreHeure) {
		this.id = id;
		this.type = type;
		this.nombreHeure = nombreHeure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Time getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(Time nombreHeure) {
		this.nombreHeure = nombreHeure;
	}

}
