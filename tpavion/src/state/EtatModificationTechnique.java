package state;

import java.util.List;
import java.util.Scanner;
import data_model.Avion;
import data_model.TypeAvion;
import decorator.DecorateurModificationAvion;
import decorator.DecorateurNonNavigant;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatModificationTechnique extends EtatTechnique {
    /**
     * Méthode qui contient les modifications réalisables pour un avion
     * @param systemeGestion
     */
    @Override
    public void goNext(SystemeGestion systemeGestion) {
        List<Avion> avions = systemeGestion.getSystemeGestionAvion().rechercherAvions();
        afficherAvions(avions);
        System.out.println("Immatriculation de l'avion : ");
        Scanner sc = new Scanner(System.in);
        String immatriculation = sc.nextLine();
        Avion avion = systemeGestion.getSystemeGestionAvion().rechercherAvion(new Avion(immatriculation));

        if(avion==null) {
            System.out.println(" ID incorrect : retour au menu pr�c�dent");
            systemeGestion.retourMenuPrecedent();
        } else {
            DecorateurModificationAvion d = new DecorateurModificationAvion(new DecorateurNonNavigant(new Implementation()),avion);
            d.affichage();
            sc = new Scanner(System.in);
            int value = sc.nextInt();
            boolean erreur = false;
            switch(value) {
                case 1:
                    deconnexion(systemeGestion);
                    break;
                case 2:
                    ajoutPassager(systemeGestion);
                    break;
                case 3:
                    int capacite = saisirInt(" Capacit� : ");
                    avion.setCapacite(capacite);
                    break;
                case 4:
                    List<TypeAvion> types = systemeGestion.getSystemeGestionAvion().rechercherTypes();
                    d.affichageListeType(types);
                    int type = saisirInt(" Type :");
                    if(type <= types.size())
                        avion.setType(types.get(type-1));
                    else
                        erreur = true;
                        break;
                default:
                    System.out.println("Erreur lors de la saisie ... ");
                    systemeGestion.afficherInterface();
                    break;
            }
            if(!erreur && systemeGestion.getSystemeGestionAvion().majAvion(avion))
                System.out.println("Modification effectu�e.");
            else 
                System.out.println("Erreur lors de la modification");
            systemeGestion.afficherInterface();
        }
    }
}
