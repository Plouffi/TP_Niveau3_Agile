package state;

import java.util.Scanner;

import decorator.DecorateurMenuGestionnaire;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuGestionnaire extends Etat{

	@Override
	public void goNext(SystemeGestion systemeGestion) {
    	Implementation i = new Implementation();
        DecorateurMenuGestionnaire d = new DecorateurMenuGestionnaire(new DecorateurNonNavigant(i));
        d.affichage();
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
        	case 1 :
        		deconnexion(systemeGestion);
        		break;
        	case 2:
        		ajoutPassager(systemeGestion);
        		break;
        	case 3:
        		System.out.println("Ajout d'un nouvel utilisateur");
        		break;
        	case 4:
        		System.out.println("Modifier un utilisateur");
        		systemeGestion.setState(new EtatMenuTechnique());
        		break;
        	case 5:
        		System.out.println("Supprimer un utilisateur");
        		systemeGestion.setState(new EtatMenuGestionnaire());
        		break;
        	case 6:
        		systemeGestion.retourMenuPrecedent();
        		break;
        	default:
        		System.out.println("Erreur...");
        		break;
        }
        systemeGestion.setState(this);
	}

}
