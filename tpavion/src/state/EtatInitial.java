package state;

import systeme.SystemeGestion;

public class EtatInitial extends Etat {
	/**
	 * M�thode qui contient la connexion
	 * @param systemeGestion
	 */
	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("----------MENU----------");
		System.out.println(" Connexion : ");
		int id = saisirInt(" identifiant :");
		String motDePasse = saisirString(" mot de passe :");
		/* on v�rifie si l'utilisateur s'est bien connect� */
		if(systemeGestion.getSystemeGestionUtilisateur().connexion(id, motDePasse)) {
			System.out.println("La connexion est un succ�s.");
			/* si la connexion est un succ�s */
			systemeGestion.setState(new EtatMenuConnecte());
		}else {
			System.out.println("La connexion a �chou�e, veuillez r�essayer.");
			systemeGestion.afficherInterface();
		}

	}

}
