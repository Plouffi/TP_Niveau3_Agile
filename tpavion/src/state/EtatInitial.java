package state;

import systeme.SystemeGestion;

public class EtatInitial extends Etat {
	/**
	 * Méthode qui contient la connexion
	 * @param systemeGestion
	 */
	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("----------MENU----------");
		System.out.println(" Connexion : ");
		int id = saisirInt(" identifiant :");
		String motDePasse = saisirString(" mot de passe :");
		/* on vérifie si l'utilisateur s'est bien connecté */
		if(systemeGestion.getSystemeGestionUtilisateur().connexion(id, motDePasse)) {
			System.out.println("La connexion est un succès.");
			/* si la connexion est un succès */
			systemeGestion.setState(new EtatMenuConnecte());
		}else {
			System.out.println("La connexion a échouée, veuillez réessayer.");
			systemeGestion.afficherInterface();
		}

	}

}
