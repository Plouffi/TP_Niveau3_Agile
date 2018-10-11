package state;

import java.util.Scanner;

public class EtatInitial implements Etat {

	@Override
	public void goNext(Contexte c) {
		System.out.println("----------MENU-----------");
		System.out.println(" Connexion : ");
		System.out.println(" --> identifiant (numéro) :");
	    int id = new Scanner(System.in).nextInt();
		System.out.println(" --> mot de passe :");
	    String password = new Scanner(System.in).nextLine();
	    if(c.getElement().getSystemeGestionUtilisateur().connexion(id, password)) {
	    	System.out.println("La connexion est un succès.");
	    	/* si la connexion est un succès */
	    	c.setState(new EtatMenuConnecte());  
		}else {
	    	System.out.println("La connexion a échouée, veuillez réessayer.");
	    	c.setState(this);
	    }
	}

}
