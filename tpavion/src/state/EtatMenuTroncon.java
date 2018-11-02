package state;

import java.sql.Time;
import java.util.Scanner;

import data_model.Troncon;
import data_model.Vol;
import data_model.VolTroncon;
import decorator.DecorateurMenuGestionnaire;
import decorator.DecorateurMenuVolTroncon;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;


public class EtatMenuTroncon extends Etat{

    /**
     * Méthode qui contient toutes les actions qu'un membre du service gestionnaire peut faire en relation avec la gestion des vols/tronçon
     * @param systemeGestion
     */
    @Override
    public void goNext(SystemeGestion systemeGestion) {
        DecorateurMenuVolTroncon d = new DecorateurMenuVolTroncon(new DecorateurNonNavigant(new Implementation()));
        d.affichage();
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
            case 1 :
                deconnexion(systemeGestion);
                break;
            case 2:
                System.out.println("Ajout d'un nouveau vol :");
                systemeGestion.getSystemeGestionVol().ajouteVol(new Vol(
                    saisirInt("Veuillez saisir la fréquence du vol (par semaine)")));
                    break;
            case 3:
                System.out.println("Modification d'un vol existant (par identifiant) :");
                systemeGestion.getSystemeGestionVol().majVol(new Vol(
                    saisirInt("Veuillez saisir l'identifiant du vol cible"),
                    saisirInt("Veuillez saisir la nouvelle fréquence du vol (par semaine)")));
                    break;
            case 4:
                System.out.println("Suppression d'un vol existant (par identifiant) :");
                systemeGestion.getSystemeGestionVol().supprimerVol(new Vol(
                    saisirInt("Veuillez saisir l'identifiant du vol"),0));
                break;
            case 5:
                System.out.println("Recherche d'un vol existant (par identifiant) :");
                Vol v15 = systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(
                    saisirInt("Veuillez saisir l'identifiant du vol"), 0));
                v15.toString();
                break;
            case 6:
                System.out.println("Ajout d'un nouveau tronçon :");
                systemeGestion.getSystemeGestionVol().ajouteTroncon(new Troncon(
                    saisirString("Veuillez saisir la ville de départ du tronçon"),
                    saisirString("Veuillez saisir la ville d'arrivée du tronçon"),
                    saisirInt("Veuillez saisir la distance du tronçon")));
                break;
            case 7:
                System.out.println("Modification un tronçon existant (par identifiant) :");
                systemeGestion.getSystemeGestionVol().majTroncon(new Troncon(
                    saisirInt("Veuillez saisir l'identifiant du tronçon cible"), 
                    saisirString("Veuillez saisir la nouvelle ville de départ du tronçon"), 
                    saisirString("Veuillez saisir la nouvelle ville d'arrivée du tronçon"), 
                    saisirInt("Veuillez saisir la nouvelle distance du tronçon")));
                    break;
            case 8:
                System.out.println("Suppression un tronçon existant (par identifiant) :");
                systemeGestion.getSystemeGestionVol().supprimerTroncon(new Troncon(
                    saisirInt("Veuillez saisir l'identifiant du tronçon"), null, null, 0));
                break;
            case 9:
                System.out.println("Recherche un tronçon existant (par identifiant) :");
                int id17 = saisirInt("Veuillez saisir l'identifiant du tronçon");
                Troncon t17 = systemeGestion.getSystemeGestionVol().rechercherTroncon(new Troncon(id17, null, null, 0));
                t17.toString();
                break;
            case 10:
                System.out.println("Association d'un vol à un tronçon :");
                systemeGestion.getSystemeGestionVol().associerVolTroncon(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du vol"), 0),//SEUL L'IDENTIFIANT SERA UTILISE
                    new Troncon(saisirInt("Veuillez saisir l'identifiant du tronçon"), "", "", 0),//SEUL L'IDENTIFIANT SERA UTILISE
                    Time.valueOf(saisirString("Veuillez saisir l'heure de départ (format : hh:mm:ss)")), 
                    Time.valueOf(saisirString("Veuillez saisir l'heure d'arrivée (format : hh:mm:ss)")));
                break;
            case 11://MODIFIER LE TEXTE
                System.out.println("Modification d'une association d'un vol à un tronçon :");
                systemeGestion.getSystemeGestionVol().majVolTroncon(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du vol associé"), 0),//SEUL L'IDENTIFIANT SERA UTILIS�
                    new Troncon(saisirInt("Veuillez saisir l'identifiant du tronçon associé"), "", "", 0),//SEUL L'IDENTIFIANT SERA UTILIS�
                    Time.valueOf(saisirString("Veuillez saisir la nouvelle heure de départ (format : hh:mm:ss)")), 
                    Time.valueOf(saisirString("Veuillez saisir la nouvelle heure d'arrivée (format : hh:mm:ss)")));
                break;
            case 12:
                System.out.println("Supression d'une association d'un vol à un tronçon :");
                systemeGestion.getSystemeGestionVol().supprimerVolTroncon(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du vol"), 0),//SEUL L'IDENTIFIANT SERA UTILIS�
                    new Troncon(saisirInt("Veuillez saisir l'identifiant du tronçon"), "", "", 0),null, null);
                break;
            case 13:
                System.out.println("Recherche d'une association d'un vol à un tronçon :");
                VolTroncon v18 = systemeGestion.getSystemeGestionVol().rechercherVolTroncon(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du vol associé"), 0), 
                    new Troncon(saisirInt("Veuillez saisir l'identifiant du tronçon associé"), null, null, 0), null, null);
                v18.toString();
                break;
            case 14:
                systemeGestion.retourMenuPrecedent();
                break;
            default:
                System.out.println("Erreur...");
                break;
        }
        systemeGestion.setState(this);
    }
}