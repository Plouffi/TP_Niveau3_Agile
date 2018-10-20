package decorator;

import data_model.Avion;

public class DecorateurModificationAvion extends DecorateurTechnique{

	private Avion avion;

	/**
	 * Constructeur d'un DecorateurModificationAvion
	 * @param a
	 * @param avion
	 */
	public DecorateurModificationAvion(Abstraction a,Avion avion) {
		super(a);
		this.avion = avion;
	}

	/**
	 * M�thode permettant l'affichage du menu
	 */
	public void affichage() {
		a.affichage();
		System.out.println(" 3 --> Modifier la capacit� (capacite actuelle : "+avion.getCapacite()+" )");
		System.out.println(" 4 --> Modifier le type (type actuel : "+avion.getType()+" )");
	}
}
