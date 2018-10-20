package decorator;

public class DecorateurMenuGestionnaire extends Decorateur{
	/**
	 * Constructeur d'un DecorateurMenuGestionnaire
	 * @param a
	 */
	public DecorateurMenuGestionnaire(Abstraction a) {
		super(a);
	}

	/**
	 * M�thode permettant l'affichage du menu
	 */
	@Override
	public void affichage() {
		a.affichage();
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
