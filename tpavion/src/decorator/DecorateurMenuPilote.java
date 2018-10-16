package decorator;

public class DecorateurMenuPilote extends Decorateur {

	public DecorateurMenuPilote(Abstraction a) {
		super(a);
	}

	@Override
	public void affichage() {
		a.affichage();
		System.out.println(" --> Saisir un rapport de vol");
		System.out.println(" --> Retour au menu précédent...");
	}

}
