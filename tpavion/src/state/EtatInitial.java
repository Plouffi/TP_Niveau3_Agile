package state;

import java.util.Scanner;

import systeme.SystemeGestion;

public class EtatInitial extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("----------MENU-----------");
		System.out.println(" Connexion : ");
		System.out.println(" --> identifiant (num�ro) :");
	    int id = new Scanner(System.in).nextInt();
		System.out.println(" --> mot de passe :");
	    String password = new Scanner(System.in).nextLine();
	    if(systemeGestion.connexion(id, password)) {
	    	System.out.println("La connexion est un succ�s.");
	    	/* si la connexion est un succ�s */
	    	systemeGestion.setState(new EtatMenuConnecte());  
		}else {
	    	System.out.println("La connexion a �chou�e, veuillez r�essayer.");
	    	systemeGestion.setState(this);
	    }
	}

}
