package decorator;

public class DecorateurNonNavigant extends Decorateur {
	/**
	 * Constructeur d'un DecorateurNonNavigant
	 * @param a
	 */
	public DecorateurNonNavigant(Abstraction a) {
		super(a);
	}

	/**
	 * M�thode permettant l'affichage du menu
	 */
	@Override
	public void affichage() {
		a.affichage();
	    System.out.println(" 2 --> Ajouter un passager � un d�part");

	}

}
