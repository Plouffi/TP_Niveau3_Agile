package state;

import java.util.Scanner;

import decorator.DecorateurMenuPilote;
import decorator.Implementation;
import systeme.SystemeGestion;

public class EtatMenuPilote extends Etat {
    /**
     * Méthode qui contient toutes les actions qu'un pilote peut effectuer
     * @param systemeGestion
     */
    @Override
    public void goNext(SystemeGestion systemeGestion) {
        DecorateurMenuPilote d = new DecorateurMenuPilote(new Implementation());
        d.affichage();
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix){
            case 1 :
                deconnexion(systemeGestion);
                break;
            case 2:
                System.out.println("Ajout d'un nouvel utilisateur");
                break;
            case 3:
                System.out.println("Modifier un utilisateur");
                systemeGestion.setState(new EtatMenuTechnique());
                break;
            case 4:
                System.out.println("Supprimer un utilisateur");
                systemeGestion.setState(new EtatMenuGestionnaire());
                break;
            case 5:
                systemeGestion.retourMenuPrecedent();
                break;
            default:
                System.out.println("Erreur...");
                break;
        }
        systemeGestion.setState(this);
    }
}
