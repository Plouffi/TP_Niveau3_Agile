package decorator;

public class DecorateurMenuGestionnaire extends Decorateur{

	public DecorateurMenuGestionnaire(Abstraction a) {
		super(a);
	}

	@Override
	public void affichage() {
		a.affichage();
	    System.out.println(" --> Ajouter un passager � un d�part");
		System.out.println(" --> Ajouter un nouveau vol");
		System.out.println(" --> Ajouter un nouveau d�part");
		System.out.println(" --> Associer un vol � un troncon");
		System.out.println(" --> Modifier un vol existant");
		System.out.println(" --> Modifier un d�part existant");
		System.out.println(" --> Supprimer un vol existant");
		System.out.println(" --> Supprimer un d�part existant");
		System.out.println(" --> Retour au menu pr�c�dent...");
	}

}
