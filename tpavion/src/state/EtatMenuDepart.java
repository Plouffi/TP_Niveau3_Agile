package state;

import java.sql.Date;
import java.util.Scanner;
import java.util.logging.Level;

import data_model.Avion;
import data_model.Depart;
import data_model.DepartAvion;
import data_model.Vol;
import decorator.DecorateurMenuDepart;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuDepart extends Etat{
	private static final String CONSTANTEID = "Veuillez saisir l'identifiant du départ";
	private static final String CONSTANTEDATE ="Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)";
	private static final String CONSTANTEAVION = "Veuillez entrer l'immatriculation de l'avion qui effectuera le vol";
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
                log.log(Level.INFO,"Ajout d'un nouveau depart :");
                systemeGestion.getSystemeGestionDepart().ajouteDepart(new Depart(
                    new Vol(saisirInt(CONSTANTEID), 0, ""), 
                    Date.valueOf(saisirString(CONSTANTEDATE))));
                break;
            case 4:
                log.log(Level.INFO,"Modification un depart existant :");
                systemeGestion.getSystemeGestionDepart().majDepart(new Depart(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du départ cible"), 0, ""), 
                    Date.valueOf(saisirString(CONSTANTEDATE))));
                break;
            case 5:
                log.log(Level.INFO,"Suppression un depart existant :");
                systemeGestion.getSystemeGestionDepart().supprimerDepart(new Depart(
                    new Vol(saisirInt(CONSTANTEID), ""), 
                    null));
                break;
            case 6:
                log.log(Level.INFO,"Recherche d'un depart existant :");
                Depart d16 = systemeGestion.getSystemeGestionDepart().rechercherDepart(new Depart(
                    new Vol(saisirInt(CONSTANTEID), 0, ""),
                    Date.valueOf(saisirString(CONSTANTEDATE))));
                d16.toString();
                break;
            case 7:
                log.log(Level.INFO,"Programmation d'un vol en un départ :");
                Vol v =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer"),0, ""));
                Depart date = new Depart(v,Date.valueOf(saisirString(CONSTANTEDATE)));
                systemeGestion.getSystemeGestionDepart().ajouteDepartAvion(new DepartAvion(date,
                    new Avion(saisirString(CONSTANTEAVION)),
                    saisirInt("Veuillez entrer la quantit� de carburant nécéssaire pour le vol")));
                break;
            case 8:
                log.log(Level.INFO,"Modification de la programmation d'un départ existant :");
                Vol vol =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer"), 0, ""));
                Depart dateModif = new Depart(vol,Date.valueOf(saisirString(CONSTANTEDATE)));
                systemeGestion.getSystemeGestionDepart().majDepartAvion(new DepartAvion(dateModif,
                        new Avion(saisirString(CONSTANTEAVION)),
                        saisirInt("Veuillez entrer la quantit� de carburant nécéssaire pour le vol")));
                break;
            case 9:
                log.log(Level.INFO,"Suppression de la programmation d'un départ existant :");
                Vol volSuppr =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à supprimer"), 0, ""));
                Depart departSuppr = new Depart(volSuppr,Date.valueOf(saisirString(CONSTANTEDATE)));
                
                systemeGestion.getSystemeGestionDepart().supprimerDepartAvion(new DepartAvion(
                    departSuppr,
                    new Avion(saisirString(CONSTANTEAVION)),
                    0));
                break;
            case 10:
                log.log(Level.INFO,"Recherche de la programmation d'un depart existant :");
                Vol volRech =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à supprimer"), 0, ""));
                Depart departRech = new Depart(volRech,Date.valueOf(saisirString(CONSTANTEDATE)));
              
                DepartAvion d9 = systemeGestion.getSystemeGestionDepart().rechercherDepartAvion(new DepartAvion(
                        departRech,
                        new Avion(saisirString(CONSTANTEAVION)),
                    0));
                d9.toString();
                break;
            case 11:
                systemeGestion.retourMenuPrecedent();
                break;
            default:
                log.log(Level.INFO,"Erreur...");
                break;
        }
        systemeGestion.setState(this);
    }
}
