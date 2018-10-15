package decorator;

import data_model.Avion;

public class DecorateurModificationAvion extends Decorateur{

	private Avion avion;
	
	public DecorateurModificationAvion(Abstraction a,Avion avion) {
		super(a);
		this.avion = avion;
	}

	public void affichage() {
		a.affichage();
		System.out.println(" 3 --> Modifier la capacité (capacite actuelle : "+avion.getCapacite()+" )");
		System.out.println(" 4 --> Modifier le type (type actuel : "+avion.getType()+" )");
	}
}
