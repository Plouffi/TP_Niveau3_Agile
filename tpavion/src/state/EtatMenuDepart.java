package state;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import data_model.Avion;
import data_model.Depart;
import data_model.DepartAvion;
import data_model.DepartPassager;
import data_model.Troncon;
import data_model.Vol;
import data_model.VolTroncon;
import decorator.DecorateurMenuDepart;
import decorator.DecorateurMenuGestionnaire;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuDepart extends Etat{

    /**
     * Méthode qui contient toutes les actions qu'un membre du service gestionnaire peut faire en relation avec la gestion des départs
     * @param systemeGestion
     */
    @Override
    public void goNext(SystemeGestion systemeGestion) {
        DecorateurMenuDepart d = new DecorateurMenuDepart(new DecorateurNonNavigant(new Implementation()));
        d.affichage();
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
            case 1 :
                deconnexion(systemeGestion);
                break;
            case 2 :
                ajoutPassager(systemeGestion);
                break;
            case 3:
                System.out.println("Ajout d'un nouveau depart :");
                systemeGestion.getSystemeGestionDepart().ajouteDepart(new Depart(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du départ")), 
                    Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)"))));
                break;
            case 4:
                System.out.println("Modification un depart existant :");
                systemeGestion.getSystemeGestionDepart().majDepart(new Depart(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du départ cible")), 
                    Date.valueOf(saisirString("Veuillez saisir la nouvelle date du départ (format : yyyy-[m]m-[d]d)"))));
                break;
            case 5:
                System.out.println("Suppression un depart existant :");
                systemeGestion.getSystemeGestionDepart().supprimerDepart(new Depart(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du départ")), 
                    null));
                break;
            case 6:
                System.out.println("Recherche d'un depart existant :");
                Depart d16 = systemeGestion.getSystemeGestionDepart().rechercherDepart(new Depart(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du départ")),
                    Date.valueOf(saisirString("Veuillez saisir la nouvelle date du départ (format : yyyy-[m]m-[d]d)"))));
                d16.toString();
                break;
            case 7:
                System.out.println("Programmation d'un vol en un départ :");
                Vol v =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer")));
                Depart date = new Depart(v,Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")));
                systemeGestion.getSystemeGestionDepart().ajouteDepartAvion(new DepartAvion(date,
                    new Avion(saisirString("Veuillez entrer l'immatriculation de l'avion qui effectuera le vol")),
                    saisirInt("Veuillez entrer la quantit� de carburant nécéssaire pour le vol")));
                break;
            case 8:
                System.out.println("Modification de la programmation d'un départ existant :");
                Vol vol =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer")));
                Depart dateModif = new Depart(vol,Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")));
                systemeGestion.getSystemeGestionDepart().majDepartAvion(new DepartAvion(dateModif,
                        new Avion(saisirString("Veuillez entrer l'immatriculation de l'avion qui effectuera le vol")),
                        saisirInt("Veuillez entrer la quantit� de carburant nécéssaire pour le vol")));
                break;
            case 9:
                System.out.println("Suppression de la programmation d'un départ existant :");
                Vol volSuppr =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à supprimer")));
                Depart departSuppr = new Depart(volSuppr,Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")));
                
                systemeGestion.getSystemeGestionDepart().supprimerDepartAvion(new DepartAvion(
                    departSuppr,
                    new Avion(saisirString("Veuillez entrer l'immatriculation de l'avion qui effectuera le vol")),
                    0));
                break;
            case 10:
                System.out.println("Recherche de la programmation d'un depart existant :");
                Vol volRech =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à supprimer")));
                Depart departRech = new Depart(volRech,Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")));
              
                DepartAvion d9 = systemeGestion.getSystemeGestionDepart().rechercherDepartAvion(new DepartAvion(
                        departRech,
                        new Avion(saisirString("Veuillez entrer l'immatriculation de l'avion qui effectuera le vol")),
                    0));
                d9.toString();
                break;
            case 11:
                systemeGestion.retourMenuPrecedent();
                break;
            default:
                System.out.println("Erreur...");
                break;
        }
        systemeGestion.setState(this);
    }
}
