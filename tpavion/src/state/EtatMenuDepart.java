package state;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

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
            case 2:
                System.out.println("Ajout d'un nouveau depart :");
                systemeGestion.getSystemeGestionDepart().ajouteDepart(new Depart(
                    saisirInt("Veuillez saisir l'identifiant du départ"), 
                    Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)"))));
                break;
            case 3:
                System.out.println("Modification un depart existant :");
                systemeGestion.getSystemeGestionDepart().majDepart(new Depart(
                    saisirInt("Veuillez saisir l'identifiant du départ cible"), 
                    Date.valueOf(saisirString("Veuillez saisir la nouvelle date du départ (format : yyyy-[m]m-[d]d)"))));
                break;
            case 4:
                System.out.println("Suppression un depart existant :");
                systemeGestion.getSystemeGestionDepart().supprimerDepart(new Depart(
                    saisirInt("Veuillez saisir l'identifiant du départ"), 
                    null));
                break;
            case 5:
                System.out.println("Recherche d'un depart existant :");
                Depart d16 = systemeGestion.getSystemeGestionDepart().rechercherDepart(new Depart(
                    saisirInt("Veuillez saisir l'identifiant du départ"),
                    null));
                d16.toString();
                break;
            case 6:
                System.out.println("Programmation d'un vol en un départ :");
                systemeGestion.getSystemeGestionDepart().ajouteDepartAvion(new DepartAvion(
                    saisirInt("Veuillez saisir l'identifiant du vol à programmer"), 
                    Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")),
                    saisirString("Veuillez entrer l'immatriculation de l'avion qui effectuera le vol"),
                    saisirInt("Veuillez entrer la quantit� de carburant nécéssaire pour le vol")));
                break;
            case 7:
                System.out.println("Modification de la programmation d'un départ existant :");
                systemeGestion.getSystemeGestionDepart().majDepartAvion(new DepartAvion(
                    saisirInt("Veuillez saisir l'identifiant du vol à re-programmer"), 
                    Date.valueOf(saisirString("Veuillez saisir la date du départ mise à jour (format : yyyy-[m]m-[d]d)")),
                    saisirString("Veuillez entrer la nouvelle immatriculation de l'avion qui effectuera le vol"),
                    saisirInt("Veuillez entrer la nouvelle quantité de carburant nécéssaire pour le vol")));
                break;
            case 8:
                System.out.println("Suppression de la programmation d'un départ existant :");
                systemeGestion.getSystemeGestionDepart().supprimerDepartAvion(new DepartAvion(
                    saisirInt("Veuillez saisir l'identifiant du vol dont la programmation du départ sera supprimée"), 
                    null,
                    "",
                    0));
                break;
            case 9:
                System.out.println("Recherche de la programmation d'un depart existant :");
                DepartAvion d9 = systemeGestion.getSystemeGestionDepart().rechercherDepartAvion(new DepartAvion(
                    saisirInt("Veuillez saisir l'identifiant du vol correspondant à la programmation cherchée"), 
                    Date.valueOf(saisirString("Veuillez saisir la date du départ du vol recherché (format : yyyy-[m]m-[d]d)")),
                    saisirString("Veuillez entrer l'immatriculation du vol correspondant au départ recherché"),
                    0));
                d9.toString();
                break;
            //programmer un vol pour un départ (et vérifier avant si le vol et l'avion existe).
            //programmer un passager pour un départ (et vérifier avant si le passager existe).
            case 10:
                System.out.println("Programmation d'un passager pour un départ :");
                systemeGestion.getSystemeGestionDepart().ajouteDepartPassager(new DepartPassager(
                    //string int date int  num id datedepart numplace
                    saisirString("Veuillez entrer le numéro du passeport du passager à programmer"),
                    saisirInt("Veuillez saisir l'identifiant de la programmation du vol du passager"), 
                    Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")),//INUTILE!
                    saisirInt("Veuillez saisir le numéro du siège")));
                break;
            case 11:
                System.out.println("Modification de la programmation du départ d'un passager :");
                systemeGestion.getSystemeGestionDepart().majDepartPassager(new DepartPassager(
                    saisirString("Veuillez entrer le numéro du passeport du passager correspondant à la programmation à modifier"),
                    saisirInt("Veuillez saisir le nouvel identifiant de la programmation du vol du passager"), 
                    Date.valueOf(saisirString("Veuillez saisir la nouvelle date du départ (format : yyyy-[m]m-[d]d)")),
                    saisirInt("Veuillez saisir le nouveau numéro du siège")));
                break;
            case 12:
                System.out.println("Suppression de la programmation du départ d'un passager :");
                systemeGestion.getSystemeGestionDepart().supprimerDepartPassager(new DepartPassager(
                    saisirString("Veuillez entrer le numéro du passeport du passager correspondant à la programmation à supprimer"),
                    0,
                    Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")),
                    0));
                break;
            case 13:
                System.out.println("Recherche de la programmation du départ d'un passager :");
                DepartPassager d13 = systemeGestion.getSystemeGestionDepart().rechercherDepartPassager(new DepartPassager(
                    saisirString("Veuillez entrer le numéro du passeport du passager correspondant à la programmation à supprimer"),
                    0,
                    Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)")),
                    0));
                d13.toString();
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
