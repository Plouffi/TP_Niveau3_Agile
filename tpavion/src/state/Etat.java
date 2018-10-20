package state;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

import systeme.SystemeGestion;

public abstract class Etat 
{
    /**
     * Méthode qui contient toutes les actions é effectuer
     * @param systemeGestion
     */
    public abstract void goNext(SystemeGestion systemeGestion);
    // méthode qui sera utilisée pour effectuer des actions et si il y a des états
    // qui suivent l'etat courant alors on déterminera l'etat suivant dans cette méthode

    /**
     * Méthode permettant la déconnexion
     * @param systemeGestion
     */
    void deconnexion(SystemeGestion systemeGestion) {
		System.out.println("Déconnexion ...");
		systemeGestion.deconnexion();
    }

    /**
     * Méthode permettant la connexion
     * @param systemeGestion
     */
    void ajoutPassager(SystemeGestion systemeGestion) {
		System.out.println("Ajout d'un passager à un départ");
		systemeGestion.setState(new EtatMenuPersonnel());
    }

    /**
     * Méthode permettant de saisir une valeur numérique
     * @param intitule
     * @return int
     */
    public int saisirInt(String intitule) {
        System.out.println(intitule);
        try{
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            return i;
        } catch (InputMismatchException e){
            System.out.println("Erreur de saisie (type de donnée non conforme");
            return saisirInt(intitule);
        }
    }

    /**
     * Méthode permettant de saisir une chaine de caractéres
     * @param intitule
     * @return String
     */
    public String saisirString(String intitule) {
        System.out.println(intitule);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Méthode permettant de saisir un BigInteger
     * @param intitule
     * @return BigInteger
     */
    public BigInteger saisirBigInteger(String intitule) {
        System.out.println(intitule);
        try{
            Scanner sc = new Scanner(System.in);
            BigInteger bi = sc.nextBigInteger();
            return bi;
        } catch (InputMismatchException e){
            System.out.println("Erreur de saisie (type de donnée non conforme");
            return saisirBigInteger(intitule);
        }
    }
}
