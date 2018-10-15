package data_model;

public class Avion {
	private String immatriculation;
	private int capacite;
	private TypeAvion type;
	
	public Avion(String immatriculation, int capacite,TypeAvion type) {
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
	
	public TypeAvion getType() {
		return type;
	}
	
	public void setType(TypeAvion type) {
		this.type = type;
	}
	
}
