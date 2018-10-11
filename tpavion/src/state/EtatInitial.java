package state;

import java.util.Scanner;

public class EtatInitial implements Etat {

	@Override
	public void goNext(Contexte c) {
		System.out.println("----------MENU-----------");
		System.out.println(" Connexion : ");
		System.out.println(" --> identifiant (num�ro) :");
	    int id = new Scanner(System.in).nextInt();
		System.out.println(" --> mot de passe :");
	    String password = new Scanner(System.in).nextLine();
	    if(c.getElement().getSystemeGestionUtilisateur().connexion(id, password)) {
	    	System.out.println("La connexion est un succ�s.");
	    	/* si la connexion est un succ�s */
	    	c.setState(new EtatMenuConnecte());  
		}else {
	    	System.out.println("La connexion a �chou�e, veuillez r�essayer.");
	    	c.setState(this);
	    }
	}

}
