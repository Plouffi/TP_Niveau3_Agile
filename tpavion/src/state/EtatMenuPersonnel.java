package state;

import java.math.BigInteger;
import java.util.Scanner;

import decorator.DecorateurMenuPersonnel;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuPersonnel extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
    	Implementation i = new Implementation();
        DecorateurMenuPersonnel d = new DecorateurMenuPersonnel(new DecorateurNonNavigant(i));
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
        		ajoutUilisateur(systemeGestion);
        		break;
        	case 4:
        		System.out.println("Ajout d'un nouveau rôle");
        		ajoutRole(systemeGestion);
        		break;
        	case 5:
        		systemeGestion.setState(new EtatModificationPersonnel());
        		break;
        	case 6:
        		System.out.println("Supprimer un utilisateur");
                sc = new Scanner(System.in);
        		System.out.println("id du membre :");
                sc = new Scanner(System.in);
                int id = sc.nextInt();
                if(systemeGestion.getSystemeGestionUtilisateur().supprimerUtilisateur(id))
                	System.out.println("L'utilisateur a bien été supprimé.");
                else
                	System.out.println("Erreur lors de la suppression");
        		break;
        	case 7:
        		systemeGestion.retourMenuPrecedent();
        		break;
        	default:
        		System.out.println("Erreur...");
        		break;
        }
        systemeGestion.setState(this);
	}

	private void ajoutRole(SystemeGestion systemeGestion) {
        Scanner sc = new Scanner(System.in);
		System.out.println("Nouveau rôle :");
        sc = new Scanner(System.in);
        String role = sc.nextLine();
		System.out.println(" Type : ");
        sc = new Scanner(System.in);
        String type = sc.nextLine();
        if(systemeGestion.getSystemeGestionUtilisateur().ajouterRole(role,type))
        	System.out.println("Rôle ajouté");
        else
        	System.out.println("Erreur lors de l'ajout");
	}

	private void ajoutUilisateur(SystemeGestion systemeGestion) {
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
		System.out.println(" motDePasse : ");
        sc = new Scanner(System.in);
        String motDePasse = sc.nextLine();
		System.out.println(" Type : ");
        sc = new Scanner(System.in);
        String type = sc.nextLine();
		System.out.println(" Role : ");
        sc = new Scanner(System.in);
        String role = sc.nextLine();
		if(!systemeGestion.getSystemeGestionUtilisateur().ajouterUtilisateur(nom,prenom,adresse,noTelephone,role,motDePasse, type))
			System.out.println("erreur lors de l'ajout");
		else
			System.out.println("Ajout effectué");
	}

}
