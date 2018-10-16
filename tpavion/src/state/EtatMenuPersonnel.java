package state;

import java.math.BigInteger;
import java.util.Scanner;

import data_model.Personnel;
import data_model.Role;
import data_model.TypeRole;
import decorator.DecorateurMenuPersonnel;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuPersonnel extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
    	Implementation i = new Implementation();
        DecorateurMenuPersonnel d = new DecorateurMenuPersonnel(new DecorateurNonNavigant(i),systemeGestion.getSystemeGestionUtilisateur().getRoles());
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
        		ajoutUilisateur(systemeGestion, d);
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
        		int id = saisirInt("id du membre :");
                if(systemeGestion.getSystemeGestionUtilisateur().supprimerUtilisateur(new Personnel(id)))
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
			String role = saisirString("Role :");
			String type = saisirString("Type :");
	        if(systemeGestion.getSystemeGestionUtilisateur().ajouterRole(new Role(type,role)))
	        	System.out.println("Rôle ajouté");
	        else
	        	System.out.println("Erreur lors de l'ajout");
        }

	private void ajoutUilisateur(SystemeGestion systemeGestion, DecorateurMenuPersonnel d) {
		String nom = saisirString("Nom :");
		String prenom = saisirString("Prenom :");
        String adresse = saisirString("Adresse :");
        BigInteger noTelephone = saisirBigInteger("numéro de téléphone :");
        String motDePasse = saisirString("Mot de passe :");
        d.affichageTypeRole();
        String type = "";
        int t = saisirInt("Type :");
        switch(t) {
        	case 1:
        		type = "navigant";
        		break;
        	case 2: 
        		type = "nonnavigant";
        		break;
        	default : 
        		System.out.println("Erreur de saisie");
        		break;	
        }
        d.affichageListeRoles();
        String role = saisirString("Role :");
	    Personnel personnel = new Personnel(nom,prenom,adresse,noTelephone,motDePasse,new Role(type,role));
		if(!systemeGestion.getSystemeGestionUtilisateur().ajouterUtilisateur(personnel))
			System.out.println("erreur lors de l'ajout");
		else
			System.out.println("Ajout effectué");
        
	}

}
