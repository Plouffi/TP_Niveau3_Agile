package state;

import java.util.Scanner;

import data_model.Avion;
import data_model.TypeAvion;
import decorator.DecorateurMenuTechnique;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuTechnique extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
    	Implementation i = new Implementation();
        DecorateurMenuTechnique d = new DecorateurMenuTechnique(new DecorateurNonNavigant(i));
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
        		System.out.println("Ajout d'un nouvel avion");
        		ajoutAvion(systemeGestion);
        		break;
        	case 4:
        		System.out.println("Ajout d'un nouveau type d'avion");
        		ajoutTypeAvion(systemeGestion);
        		break;
        	case 5:
        		System.out.println("Modifier un avion");
        		systemeGestion.setState(new EtatModificationTechnique());
        		break;
        	case 6:
        		System.out.println("Supprimer un avion");
        		String immatriculation = saisirString(" Immatriculation :");
                if(systemeGestion.getSystemeGestionAvion().supprimerAvion(new Avion(immatriculation)))
                		System.out.println("Avion supprimé .");
                else
                	System.out.println("Erreur lors de la suppression");
        		break;
        	case 7:
        		System.out.println("Supprimer un type d'avion");
        		String type = saisirString(" Type :");
                if(systemeGestion.getSystemeGestionAvion().supprimerTypeAvion(new TypeAvion(type)))
                		System.out.println("Type d'avion supprimé.");
                else
                	System.out.println("Erreur lors de la suppression");
        		break;
        	case 8:
        		systemeGestion.retourMenuPrecedent();
        		break;
        	default:
        		System.out.println("Erreur...");
        		break;
        }
        systemeGestion.setState(this);
	}

	private void ajoutTypeAvion(SystemeGestion systemeGestion) {
		String type = saisirString(" Type d'avion :");
        if(systemeGestion.getSystemeGestionAvion().ajouterTypeAvion(new TypeAvion(type)))
        	System.out.println("Ajout de l'avion effectué.");
        else
        	System.out.println("Erreur lors de l'ajout ...");
	}

	private void ajoutAvion(SystemeGestion systemeGestion) {
		String immatriculation = saisirString(" Immatriculation:");
		int capacite = saisirInt(" Capacite :");
		String type = saisirString("type");
        if(systemeGestion.getSystemeGestionAvion().ajouterAvion(new Avion(immatriculation,capacite,new TypeAvion(type))))
        	System.out.println("Ajout de l'avion effectué.");
        else
        	System.out.println("Erreur lors de l'ajout ...");
	}

}
