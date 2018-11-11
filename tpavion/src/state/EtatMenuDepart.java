package state;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
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
        int choix;
        try{
        	choix = sc.nextInt();
        }
        catch(InputMismatchException e)
        {
        	choix = -1;//on va a default
        }
        boolean erreur = false;
        switch (choix){
            case 1 :
                deconnexion(systemeGestion);
                break;
            case 2 :
                ajoutPassager(systemeGestion);
                break;
            case 3:
            	System.out.println("Ajout d'un nouveau depart :");
                if(systemeGestion.getSystemeGestionDepart().ajouteDepart(new Depart(
                    new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer"), 0, ""), 
                   		Date.valueOf(saisirDate(CONSTANTEDATE)))))
                {
                	log.log(Level.INFO,"Ajout effectué");
                }
                else
                	erreur = true;
                break;
            case 4:
                System.out.println("Modification un depart existant :");
                if(systemeGestion.getSystemeGestionDepart().majDepart(new Depart(
                		new Vol(saisirInt("Veuillez saisir l'identifiant du départ cible"), 0, ""), 
                		Date.valueOf(saisirDate("Veuillez saisir la date de départ du vol à modifier (format : yyyy-[m]m-[d]d)"))),
                		Date.valueOf(saisirDate("Veuillez saisir la nouvelle date de départ (format : yyyy-[m]m-[d]d)"))))
                {
                	log.log(Level.INFO,"Modification effectué");
                }	
                break;
            case 5:
            	System.out.println("Suppression un depart existant :");
	            if(systemeGestion.getSystemeGestionDepart().supprimerDepart(new Depart(
	            	new Vol(saisirInt(CONSTANTEID), 0, ""),
	            	Date.valueOf(saisirDate(CONSTANTEDATE))
	            	)))
	            {
	            	log.log(Level.INFO,"Suppression effectuée");
	            }
	            else
	                erreur = true;
                break;
            case 6:
            	System.out.println("Recherche d'un depart existant :");
                List<Depart> departs = systemeGestion.getSystemeGestionDepart().rechercherDepart(new Depart(
                        new Vol(saisirInt(CONSTANTEID), 0, ""),
                        null));
                d.affichageListeDepart(departs);
                break;
            case 7:
            	System.out.println("Programmation d'un vol en un départ :");
            	List<Vol> v = systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer"),0, ""));
	            erreur = checkProgVol(systemeGestion,v);
                break;
            case 8:
                systemeGestion.setState(new EtatModificationDepartAvion());
                /*log.log(Level.INFO,"Modification de la programmation d'un départ existant :");
                Vol vol =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à programmer"), 0, ""));
                Depart dateModif = new Depart(vol,Date.valueOf(saisirString(CONSTANTEDATE)));
                systemeGestion.getSystemeGestionDepart().majDepartAvion(new DepartAvion(dateModif,
                        new Avion(saisirString(CONSTANTEAVION)),
                        saisirInt("Veuillez entrer la quantit� de carburant nécéssaire pour le vol")));*/
                break;
            case 9:
            	System.out.println("Suppression de la programmation d'un départ existant :");
	            List<Vol> volSuppr =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à supprimer"), 0, ""));
	            erreur = checkSupprVol(systemeGestion,volSuppr);
	            break;
            case 10:
            	System.out.println("Recherche de la programmation d'un depart existant :");
	            List<Vol> volRech =  systemeGestion.getSystemeGestionVol().rechercherVol(new Vol(saisirInt("Veuillez saisir l'identifiant du vol à rechercher"), 0, ""));
	            checkRechVol(systemeGestion,volRech,d);
                break;
            case 11:
                systemeGestion.retourMenuPrecedent();
                break;
            default:
                log.log(Level.INFO,"Erreur...");
                break;
        }
        if(erreur)
        {
           log.log(Level.INFO,"Erreur...");
        }
        systemeGestion.setState(this);
    }
	private boolean checkSupprVol(SystemeGestion systemeGestion, List<Vol> volSuppr) {
		boolean erreur = false;
		if(volSuppr != null && !volSuppr.isEmpty())
        {
            Depart departSuppr = new Depart(volSuppr.get(0),Date.valueOf(saisirDate(CONSTANTEDATE)));
            erreur = checkSupprProgVol(systemeGestion,departSuppr);
        }
        else
            erreur = true;
		return erreur;
	}
	private void checkRechVol(SystemeGestion systemeGestion, List<Vol> volRech,DecorateurMenuDepart d) {
		if(volRech != null && !volRech.isEmpty())
        {
        	Depart departRech = new Depart(volRech.get(0),null);
            		List<DepartAvion> departsAvion = systemeGestion.getSystemeGestionDepart().rechercherDepartAvion(new DepartAvion(
            			departRech,
                	new Avion(""),
                0));
	            d.affichageListeDepartAvion(departsAvion);
        }
	}
	private boolean checkSupprProgVol(SystemeGestion systemeGestion, Depart departSuppr) {
		boolean erreur = false;
		if(systemeGestion.getSystemeGestionDepart().supprimerDepartAvion(new DepartAvion(
                departSuppr,
                new Avion(saisirString(CONSTANTEAVION)),
                0)))
                log.log(Level.INFO,"DepartAvion supprimé");
            else
                erreur = true;
		return erreur;
	}
	
	private boolean checkProgVol(SystemeGestion systemeGestion,List<Vol> v) {
		boolean erreur = false;
    	if(v != null && !v.isEmpty())
        {
            if(systemeGestion.getSystemeGestionDepart().ajouteDepartAvion(new DepartAvion(new Depart(v.get(0),Date.valueOf(saisirDate(CONSTANTEDATE))),
            		new Avion(saisirString(CONSTANTEAVION)),
            		saisirInt("Veuillez entrer la quantité de carburant nécéssaire pour le vol"))))
            	log.log(Level.INFO,"DepartAvion Ajouté");
            else
            	erreur = true;
        }
        else
            erreur = true;
    	return erreur;
	} 
}
