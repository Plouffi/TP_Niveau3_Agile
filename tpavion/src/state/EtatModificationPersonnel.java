package state;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import data_access_object.DepartPassagerDAO;
import data_model.Personnel;
import data_model.Role;
import decorator.DecorateurMenuPrecedent;
import decorator.DecorateurModificationPersonnel;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatModificationPersonnel extends EtatPersonnel {
	/**
	 * Méthode qui contient les actions relatives à la modification d'un membre
	 * @param systemeGestion
	 */
	@Override
	public void goNext(SystemeGestion systemeGestion) {
		afficherPersonnels(systemeGestion.getSystemeGestionUtilisateur().getPersonnels());
		System.out.println("Numero du membre : ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Personnel personnel = systemeGestion.getSystemeGestionUtilisateur().rechercherUtilisateur(new Personnel(id));
        if(personnel==null) {
        	System.out.println(" ID incorrect : retour au menu précédent");
        	systemeGestion.retourMenuPrecedent();
        }
        else {
        	DecorateurModificationPersonnel d = new DecorateurModificationPersonnel(new DecorateurMenuPrecedent(new DecorateurNonNavigant(new Implementation())),personnel);
			d.affichage();
            boolean erreur = false;
            sc = new Scanner(System.in);
            id = sc.nextInt();
            switch(id) {
            	case 1:
            		deconnexion(systemeGestion);
            		break;
            	case 2:
            		ajoutPassager(systemeGestion);
            		break;
				case 3:
					systemeGestion.retourMenuPrecedent();
					break;
            	case 4:
            		String nom = saisirString(" Nom :");
                    personnel.setNom(nom);
            		break;
            	case 5:
                    String prenom = saisirString(" Prénom :");
                    personnel.setPrenom(prenom);
            		break;
            	case 6:
                    String adresse = saisirString(" Adresse :");
                    personnel.setAdresse(adresse);
            		break;
            	case 7:
                    BigInteger numeroTelephone = saisirBigInteger(" Numéro de téléphone :");
                    personnel.setNoTelephone(numeroTelephone);
            		break;
            	case 8:
                    d.affichageTypeRole();
                    int t = saisirInt("Type :");
                    String type = creerType(t);
					List<Role> roles = systemeGestion.getSystemeGestionUtilisateur().getRoles();
                    d.affichageListeRoles(roles);
                    int role = saisirInt(" Rôle :");
                    if(role<=roles.size()) {
						personnel.setRole(new Role(type, roles.get(role - 1).getRole()));
					}
					else
						erreur = true;
            		break;
            	default:
            		System.out.println("Erreur lors de la saisie ... ");
            		systemeGestion.afficherInterface();
            		break;
            }
            if(!erreur && systemeGestion.getSystemeGestionUtilisateur().majUtilisateur(personnel))
            	System.out.println("Modification effectuée.");
            else 
            	System.out.println("Erreur lors de la modification");
            systemeGestion.afficherInterface();
        }
	}

}
