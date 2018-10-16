package state;

import java.math.BigInteger;
import java.util.Scanner;

import data_model.Personnel;
import data_model.Role;
import data_model.TypeRole;
import decorator.DecorateurMenuPersonnel;
import decorator.DecorateurModificationPersonnel;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatModificationPersonnel extends Etat {

	@Override
	public void goNext(SystemeGestion systemeGestion) {
		System.out.println("Numero du membre : ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Personnel personnel = systemeGestion.getSystemeGestionUtilisateur().rechercherUtilisateur(new Personnel(id));
        if(personnel==null) {
        	System.out.println(" ID incorrect : retour au menu précédent");
        	systemeGestion.retourMenuPrecedent();
        }
        else {
        	Implementation i = new Implementation();
            DecorateurModificationPersonnel d = new DecorateurModificationPersonnel(new DecorateurNonNavigant(i),personnel,systemeGestion.getSystemeGestionUtilisateur().getRoles());
            d.affichage();
            sc = new Scanner(System.in);
            id = sc.nextInt();
            boolean modification = false;
            switch(id) {
            	case 1:
            		deconnexion(systemeGestion);
            		break;
            	case 2:
            		ajoutPassager(systemeGestion);
            		break;
            	case 3:
            		String nom = saisirString(" Nom :");
                    personnel.setNom(nom);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 4:
                    String prenom = saisirString(" Prénom :");
                    personnel.setPrenom(prenom);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 5:
                    String adresse = saisirString(" Adresse :");
                    personnel.setAdresse(adresse);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 6:
                    BigInteger numeroTelephone = saisirBigInteger(" Numéro de téléphone :");
                    personnel.setNoTelephone(numeroTelephone);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 7:
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
            		String role = saisirString(" Rôle :");
                    personnel.setRole(new Role(type,role));
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
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
