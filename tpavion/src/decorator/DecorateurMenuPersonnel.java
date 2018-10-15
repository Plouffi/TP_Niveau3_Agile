package decorator;

public class DecorateurMenuPersonnel extends Decorateur {

	public DecorateurMenuPersonnel(Abstraction a) {
		super(a);
	}

	@Override
	public void affichage() {
		a.affichage();
		System.out.println(" --> Ajouter un nouvel utilisateur");
		System.out.println(" --> Ajouter un nouveau rôle");
		System.out.println(" --> Modifier un utilisateur existant");
		System.out.println(" --> Supprimer un utilisateur existant");
		System.out.println(" --> Retour au menu précédent...");
	}

}
