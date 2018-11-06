package decorator;

import java.util.logging.Level;

public class DecorateurMenuDepart extends Decorateur{
    /**
     * Constructeur d'un DecorateurMenuDepart
     * @param a
     */
    public DecorateurMenuDepart(Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Ajouter un nouveau départ");
        log.log(Level.INFO," 4 --> Modifier un départ existant");
        log.log(Level.INFO," 5 --> Supprimer un départ existant");
        log.log(Level.INFO," 6 --> Rechercher un départ existant");
        log.log(Level.INFO," 7 --> Programmer un vol en un départ :");
        log.log(Level.INFO," 8 --> Modifier la programmation d'un départ existant :");
        log.log(Level.INFO," 9 --> Supprimer la programmation d'un départ existant :");
        log.log(Level.INFO," 10 --> Rechercher la programmation d'un depart existant :");
        log.log(Level.INFO," 11 -> Retour au menu précèdent...");
    }
}