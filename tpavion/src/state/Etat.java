package state;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;

import data_model.Passager;
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
     * Méthode permettant l'ajout d'un passager à un vol
     * @param systemeGestion
     */
    void ajoutPassager(SystemeGestion systemeGestion) {
		System.out.println("Ajout d'un passager à un départ");
		System.out.println("Création / Recherche du passager :");
		String passeport = saisirString(" numéro de passeport du passagé :");
		Passager passager = systemeGestion.getSystemeGestionUtilisateur().rechercherPassager(new Passager(passeport));
		if(passager == null) {
			String prenom = saisirString(" prénom :");
			String nom = saisirString(" nom :");
			String adresse = saisirString(" adresse :");
			String noTel = saisirString(" numéro de téléphone :");
			passager = new Passager(passeport,nom,prenom,adresse,noTel);
			systemeGestion.getSystemeGestionUtilisateur().creerPassager(passager);
		}
		System.out.println(" Recherche du depart : ");
		Date date = Date.valueOf(saisirString("Veuillez saisir la date du départ (format : yyyy-[m]m-[d]d)"));
		String villeDepart = saisirString(" ville de départ :");
		String villeArrivee = saisirString(" ville d'arrivée :");
		Time heureDepart = Time.valueOf(saisirString("Veuillez saisir la nouvelle heure de départ (format : hh:mm:ss)"));
		systemeGestion.getSystemeGestionUtilisateur().associerPassagerDepart(passager,date,villeDepart,villeArrivee,heureDepart);
		systemeGestion.setState(this);
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
