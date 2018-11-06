package decorator;

import java.util.logging.Level;

public class DecorateurMenuGestionnaire extends Decorateur{
    /**
     * Constructeur d'un DecorateurMenuGestionnaire
     * @param a
     */
    public DecorateurMenuGestionnaire(Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Gestion des vols");
        log.log(Level.INFO," 4 --> Gestion des départs");
        log.log(Level.INFO," 5 --> Retour au menu précèdent...");
    }
}
