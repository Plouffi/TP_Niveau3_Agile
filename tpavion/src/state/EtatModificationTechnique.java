package state;

import java.util.Scanner;
import data_model.Avion;
import data_model.TypeAvion;
import decorator.DecorateurModificationAvion;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatModificationTechnique extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("Immatriculation de l'avion : ");
        Scanner sc = new Scanner(System.in);
        String immatriculation = sc.nextLine();
        Avion avion = systemeGestion.getSystemeGestionAvion().rechercherAvion(new Avion(immatriculation));
        if(avion==null) {
        	System.out.println(" ID incorrect : retour au menu précédent");
        	systemeGestion.retourMenuPrecedent();
        }
        else {
        	Implementation i = new Implementation();
            DecorateurModificationAvion d = new DecorateurModificationAvion(new DecorateurNonNavigant(i),avion);
            d.affichage();
            sc = new Scanner(System.in);
            int value = sc.nextInt();
            boolean modification = false;
            switch(value) {
            	case 1:
            		deconnexion(systemeGestion);
            		break;
            	case 2:
            		ajoutPassager(systemeGestion);
            		break;
            	case 3:
            		System.out.println("Saisir une capacité :");
                    sc = new Scanner(System.in);
                    int capacite = sc.nextInt();
                    avion.setCapacite(capacite);
                    modification = systemeGestion.getSystemeGestionAvion().majAvion(avion);
            		break;
            	case 4:
            		System.out.println("Saisir un type : ");
                    sc = new Scanner(System.in);
                    String type = sc.nextLine();
                    avion.setType(new TypeAvion(type));
                    modification = systemeGestion.getSystemeGestionAvion().majAvion(avion);
            		break;
            	default:
            		System.out.println("Erreur lors de la saisie ... ");
            		systemeGestion.afficherInterface();
            		break;
            }
            if(modification)
            	System.out.println("Modification effectuée.");
            else 
            	System.out.println("Erreur lors de la modification");
            systemeGestion.afficherInterface();
        }
	}

}
