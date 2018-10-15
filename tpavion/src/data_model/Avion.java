package data_model;

public class Avion {
	private String immatriculation;
	private int capacite;
	private String type;
	
	public Avion(String immatriculation, int capacite,String type) {
		this.immatriculation = immatriculation;
		this.capacite = capacite;
		this.type = type;
	}
	
	public Avion(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	public String getImmatriculation() {
		return immatriculation;
	}
	
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	public int getCapacite() {
		return capacite;
	}
	
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
