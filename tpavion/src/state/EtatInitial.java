package state;

import java.util.Scanner;

import systeme.SystemeGestion;

public class EtatInitial extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("----------MENU-----------");
		System.out.println(" Connexion : ");
		System.out.println(" --> identifiant (numéro) :");
	    int id = new Scanner(System.in).nextInt();
		System.out.println(" --> mot de passe :");
	    String password = new Scanner(System.in).nextLine();
	    if(systemeGestion.connexion(id, password)) {
	    	System.out.println("La connexion est un succès.");
	    	/* si la connexion est un succès */
	    	systemeGestion.setState(new EtatMenuConnecte());  
		}else {
	    	System.out.println("La connexion a échouée, veuillez réessayer.");
	    	systemeGestion.setState(this);
	    }
	}

}
