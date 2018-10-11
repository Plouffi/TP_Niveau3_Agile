package state;

import java.util.Scanner;

import decorator.DecorateurMenuConnecte;
import decorator.Implementation;

public class EtatMenuConnecte implements Etat {

	@Override
	public void goNext(Contexte c) {
    	Implementation i = new Implementation();
        DecorateurMenuConnecte d = new DecorateurMenuConnecte(i);
        d.affichage(); // affiche le menu de l'administrateur
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
        	case 1 :
        		System.out.println("Déconnexion ...");
        		c.getElement().getSystemeGestionUtilisateur().deconnexion();
        		c.setState(new EtatInitial());
        		break;
        	case 2:
        		System.out.println("Menu Personnel");
        		c.setState(new EtatMenuPersonnel());
        		break;
        	case 3:
        		System.out.println("Menu Gestionnaire");
        		c.setState(new EtatMenuGestionnaire());
        		break;
        	case 4:
        		System.out.println("Menu Technique");
        		c.setState(new EtatMenuTechnique());
        		break;
        	case 5:
        		System.out.println("Menu Pilote");
        		c.setState(new EtatMenuPilote());
        		break;
        	default:
        		System.out.println("Erreur...");
        }
	}

}
