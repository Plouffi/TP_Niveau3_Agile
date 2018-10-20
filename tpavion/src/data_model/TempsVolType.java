package data_model;

import java.sql.Time;

public class TempsVolType {

	private int id;
	private int type;
	private Time nombreHeure;

	/**
	 * Constructeur pour un TempsVolType
	 * @param id
	 * @param type
	 * @param nombreHeure
	 */
	public TempsVolType(int id, int type, Time nombreHeure) {
		this.id = id;
		this.type = type;
		this.nombreHeure = nombreHeure;
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
	 * Getter du type
	 * @return int
	 */
	public int getType() {
		return type;
	}

	/**
	 * Setter du type
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Getter du nombre d'heure
	 * @return Time
	 */
	public Time getNombreHeure() {
		return nombreHeure;
	}

	/**
	 * Setter du nombre d'heure
	 * @param nombreHeure
	 */
	public void setNombreHeure(Time nombreHeure) {
		this.nombreHeure = nombreHeure;
	}

}
