package decorator;

import java.util.logging.Level;

public class DecorateurMenuPrecedent extends Decorateur{
    /**
     * Constructeur d'un DecorateurNonNavigant
     * @param a
     */
    public DecorateurMenuPrecedent(Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Retour au menu précèdent");
    }
}
