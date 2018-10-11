package state;

import java.math.BigInteger;
import java.util.Scanner;

import decorator.DecorateurMenuPersonnel;
import decorator.Implementation;

public class EtatMenuPersonnel implements Etat {

	@Override
	public void goNext(Contexte c) {
    	Implementation i = new Implementation();
        DecorateurMenuPersonnel d = new DecorateurMenuPersonnel(i);
        d.affichage();
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
        	case 1 :
        		System.out.println("Déconnexion ...");
        		c.getElement().getSystemeGestionUtilisateur().deconnexion();
        		c.setState(new EtatInitial());
        		break;
        	case 2:
        		System.out.println("Ajout d'un passager à un départ");
        		c.setState(new EtatMenuPersonnel());
        		break;
        	case 3:
        		System.out.println("Ajout d'un nouvel utilisateur");
        		ajoutUilisateur(c);
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
        c.setState(this);
	}

	private void ajoutUilisateur(Contexte c) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Nouvel Utilisateur :");
		System.out.println(" Nom : ");
        sc = new Scanner(System.in);
        String nom = sc.nextLine();
		System.out.println(" Prenom : ");
        sc = new Scanner(System.in);
        String prenom = sc.nextLine();
		System.out.println(" Adresse : ");
        sc = new Scanner(System.in);
        String adresse = sc.nextLine();
		System.out.println(" numéro de téléphone : ");
        sc = new Scanner(System.in);
        BigInteger noTelephone = BigInteger.valueOf(sc.nextLong());
		System.out.println(" Type : ");
        sc = new Scanner(System.in);
        String type = sc.nextLine();
		if(!c.getElement().getSystemeGestionUtilisateur().ajouterUtilisateur(nom,prenom,adresse,noTelephone,type))
			System.out.println(" Ajout effectué");
		else
			System.out.println("erreur lors de l'ajout");
	}

}
