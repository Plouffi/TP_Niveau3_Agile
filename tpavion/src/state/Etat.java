package state;

import java.math.BigInteger;
import java.util.Scanner;

import systeme.SystemeGestion;

public abstract class Etat 
{    
    public abstract void goNext(SystemeGestion systemeGestion);
    // m�thode qui sera utilis�e pour effectuer des actions et si il y a des �tats
    // qui suivent l'etat courant alors on d�terminera l'etat suivant dans cette m�thode
   
    void deconnexion(SystemeGestion systemeGestion) {
		System.out.println("D�connexion ...");
		systemeGestion.deconnexion();
    }
    
    void ajoutPassager(SystemeGestion systemeGestion) {
		System.out.println("Ajout d'un passager � un d�part");
		systemeGestion.setState(new EtatMenuPersonnel());
    }
    
    public int saisirInt(String intitule) {
		System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public String saisirString(String intitule) {
		System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
    public BigInteger saisirBigInteger(String intitule) {
		System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextBigInteger();
    }
}
