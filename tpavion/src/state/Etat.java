package state;

import java.math.BigInteger;
import java.util.Scanner;

import systeme.SystemeGestion;

public abstract class Etat 
{
    /**
     * M�thode qui contient toutes les actions � effectuer
     * @param systemeGestion
     */
    public abstract void goNext(SystemeGestion systemeGestion);
    // m�thode qui sera utilis�e pour effectuer des actions et si il y a des �tats
    // qui suivent l'etat courant alors on d�terminera l'etat suivant dans cette m�thode

    /**
     * M�thode permettant la d�connexion
     * @param systemeGestion
     */
    void deconnexion(SystemeGestion systemeGestion) {
		System.out.println("D�connexion ...");
		systemeGestion.deconnexion();
    }

    /**
     * M�thode permettant la connexion
     * @param systemeGestion
     */
    void ajoutPassager(SystemeGestion systemeGestion) {
		System.out.println("Ajout d'un passager � un d�part");
		systemeGestion.setState(new EtatMenuPersonnel());
    }

    /**
     * M�thode permettant de saisir une valeur num�rique
     * @param intitule
     * @return int
     */
    public int saisirInt(String intitule) {
		System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * M�thode permettant de saisir une chaine de caract�res
     * @param intitule
     * @return String
     */
    public String saisirString(String intitule) {
		System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * M�thode permettant de saisir un BigInteger
     * @param intitule
     * @return BigInteger
     */
    public BigInteger saisirBigInteger(String intitule) {
		System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextBigInteger();
    }
}
