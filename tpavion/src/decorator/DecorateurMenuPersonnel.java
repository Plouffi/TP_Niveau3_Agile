package decorator;

public class DecorateurMenuPersonnel extends Decorateur {

	public DecorateurMenuPersonnel(Abstraction a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void affichage() {
		a.affichage();
	    System.out.println(" --> Ajouter un passager � un d�part");
		System.out.println(" --> Ajouter un nouvel utilisateur");
		System.out.println(" --> Modifier un utilisateur existant");
		System.out.println(" --> Supprimer un utilisateur existant");
		System.out.println(" --> Retour au menu pr�c�dent...");
	}

}
