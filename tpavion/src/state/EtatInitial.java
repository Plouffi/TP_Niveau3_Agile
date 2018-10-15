package state;

import java.util.Scanner;

import systeme.SystemeGestion;

public class EtatInitial extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("----------MENU----------");
		System.out.println(" Connexion : ");
		int id = saisirInt(" identifiant :");
		String motDePasse = saisirString(" mot de passe :");
	    if(systemeGestion.connexion(id, motDePasse)) {
	    	System.out.println("La connexion est un succès.");
	    	/* si la connexion est un succès */
	    	systemeGestion.setState(new EtatMenuConnecte());  
		}else {
	    	System.out.println("La connexion a échouée, veuillez réessayer.");
	    	systemeGestion.setState(this);
	    }
	}

}
