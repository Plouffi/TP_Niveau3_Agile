package data_model;

public class Vol {

	private int id;
	private int frequence;
	
	public Vol(int id,int frequence){
		this.id = id;
		this.frequence = frequence;
	}

	public Vol(int frequence){
		this.frequence = frequence;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
}
