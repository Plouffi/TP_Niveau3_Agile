package state;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data_model.Avion;
import data_model.TypeAvion;
import decorator.*;
import systeme.SystemeGestion;

public class EtatMenuTechnique extends EtatTechnique {
    /**
     * Méthode qui contient toutes les actions qu'un membre du service technique peut effectuer
     * @param systemeGestion
     */
    @Override
    public void goNext(SystemeGestion systemeGestion) {
        DecorateurMenuTechnique d = new DecorateurMenuTechnique(new DecorateurNonNavigant(new Implementation()));
        d.affichage();
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
            case 1 :
                deconnexion(systemeGestion);
                break;
            case 2:
                ajoutPassager(systemeGestion);
                break;
            case 3:
                System.out.println("Ajout d'un nouvel avion");
                ajoutAvion(systemeGestion,d);
                break;
            case 4:
                System.out.println("Ajout d'un nouveau type d'avion");
                ajoutTypeAvion(systemeGestion);
                break;
            case 5:
                System.out.println("Modifier un avion");
                systemeGestion.setState(new EtatModificationTechnique());
                break;
            case 6:
                System.out.println("Supprimer un avion");
                List<Avion> avions = systemeGestion.getSystemeGestionAvion().rechercherAvions();
                d.afficherAvions(avions);
                String immatriculation = saisirString(" Immatriculation :");
                if(systemeGestion.getSystemeGestionAvion().supprimerAvion(new Avion(immatriculation)))
                    System.out.println("Avion supprimé .");
                else
                    System.out.println("Erreur lors de la suppression");
                break;
            case 7:
                System.out.println("Supprimer un type d'avion");
                List<TypeAvion> types = systemeGestion.getSystemeGestionAvion().rechercherTypes();
                d.affichageListeType(types);
                int type = saisirInt(" Type :");
                if(type <= types.size() && systemeGestion.getSystemeGestionAvion().supprimerTypeAvion(types.get(type-1)))
                    System.out.println("Type d'avion supprimé.");
            else
                System.out.println("Erreur lors de la suppression");
                break;
            case 8:
                systemeGestion.retourMenuPrecedent();
                break;
            default:
                System.out.println("Erreur...");
                break;
        }
        systemeGestion.setState(this);
    }
    /**
     * Méthode contenant l'ajout d'un type d'avion
     * @param systemeGestion
     */
    private void ajoutTypeAvion(SystemeGestion systemeGestion) {
            String type = saisirString(" Type d'avion :");
    if(systemeGestion.getSystemeGestionAvion().ajouterTypeAvion(new TypeAvion(type)))
            System.out.println("Ajout de l'avion effectué.");
    else
            System.out.println("Erreur lors de l'ajout ...");
    }

    /**
     * Méthode permettant l'ajout d'un avion
     * @param systemeGestion
     */
    private void ajoutAvion(SystemeGestion systemeGestion, DecorateurTechnique d) {
        String immatriculation = saisirString(" Immatriculation:");
        int capacite = saisirInt(" Capacite :");
        List<TypeAvion> types = systemeGestion.getSystemeGestionAvion().rechercherTypes();
        d.affichageListeType(types);
        int type = saisirInt(" Type :");
        if(type <= types.size() && systemeGestion.getSystemeGestionAvion().ajouterAvion(new Avion(immatriculation,capacite,types.get(type - 1))))
            System.out.println("Ajout de l'avion effectué.");
        else
            System.out.println("Erreur lors de l'ajout ...");
        }
}
