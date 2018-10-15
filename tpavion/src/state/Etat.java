package state;

import systeme.SystemeGestion;

public abstract class Etat 
{    
    public abstract void goNext(SystemeGestion systemeGestion);
    // méthode qui sera utilisée pour effectuer des actions et si il y a des états
    // qui suivent l'etat courant alors on déterminera l'etat suivant dans cette méthode
   
    void deconnexion(SystemeGestion systemeGestion) {
		System.out.println("Déconnexion ...");
		systemeGestion.deconnexion();
    }
    
    void ajoutPassager(SystemeGestion systemeGestion) {
		System.out.println("Ajout d'un passager à un départ");
		systemeGestion.setState(new EtatMenuPersonnel());
    }
}
