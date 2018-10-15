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
            DecorateurModificationPersonnel d = new DecorateurModificationPersonnel(new DecorateurNonNavigant(i),personnel);
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
            		System.out.println("Saisir un nom");
                    sc = new Scanner(System.in);
                    String nom = sc.nextLine();
                    personnel.setNom(nom);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 4:
            		System.out.println("Saisir un prenom");
                    sc = new Scanner(System.in);
                    String prenom = sc.nextLine();
                    personnel.setPrenom(prenom);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 5:
            		System.out.println("Saisir une adresse");
                    sc = new Scanner(System.in);
                    String adresse = sc.nextLine();
                    personnel.setAdresse(adresse);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 6:
            		System.out.println("Saisir un numéro de téléphone");
                    sc = new Scanner(System.in);
                    BigInteger numeroTelephone = sc.nextBigInteger();
                    personnel.setNoTelephone(numeroTelephone);
                    modification = systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel);
            		break;
            	case 7:
            		System.out.println("Nouveau rôle :");
                    sc = new Scanner(System.in);
                    String role = sc.nextLine();
            		System.out.println(" Type : ");
                    sc = new Scanner(System.in);
                    String type = sc.nextLine();
                    TypeRole typeRole = TypeRole.getTypePossible(type);
                    personnel.setRole(new Role(typeRole,role));
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
