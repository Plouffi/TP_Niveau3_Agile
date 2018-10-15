package decorator;

public class DecorateurNonNavigant extends Decorateur {

	public DecorateurNonNavigant(Abstraction a) {
		super(a);
	}

	@Override
	public void affichage() {
		a.affichage();
	    System.out.println(" 2 --> Ajouter un passager à un départ");

	}

}
