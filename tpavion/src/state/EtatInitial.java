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
	    	System.out.println("La connexion est un succ�s.");
	    	/* si la connexion est un succ�s */
	    	systemeGestion.setState(new EtatMenuConnecte());  
		}else {
	    	System.out.println("La connexion a �chou�e, veuillez r�essayer.");
	    	systemeGestion.setState(this);
	    }
	}

}
