package decorator;

public class DecorateurMenuGestionnaire extends Decorateur{

	public DecorateurMenuGestionnaire(Abstraction a) {
		super(a);
	}

	@Override
	public void affichage() {
		a.affichage();
	    System.out.println(" --> Ajouter un passager à un départ");
		System.out.println(" --> Ajouter un nouveau vol");
		System.out.println(" --> Ajouter un nouveau départ");
		System.out.println(" --> Associer un vol à un troncon");
		System.out.println(" --> Modifier un vol existant");
		System.out.println(" --> Modifier un départ existant");
		System.out.println(" --> Supprimer un vol existant");
		System.out.println(" --> Supprimer un départ existant");
		System.out.println(" --> Retour au menu précédent...");
	}

}
