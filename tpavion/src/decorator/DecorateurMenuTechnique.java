package decorator;

public class DecorateurMenuTechnique extends Decorateur {

	public DecorateurMenuTechnique(Abstraction a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void affichage() {
	    System.out.println(" --> Ajouter un passager à un départ");
		System.out.println(" --> Ajouter un nouvel avion");
		System.out.println(" --> Ajouter un nouveau type d'avion");
		System.out.println(" --> Modifier un avion existant");
		System.out.println(" --> Modifier un type d'avion existant");
		System.out.println(" --> Supprimer un avion existant");
		System.out.println(" --> Supprimer un type d'avion existant");
		System.out.println(" --> Retour au menu précédent...");
	}

}
