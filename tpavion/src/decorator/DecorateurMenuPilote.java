package decorator;

import java.util.logging.Level;

public class DecorateurMenuPilote extends DecorateurTechnique {
    /**
     * Constructeur d'un DecorateurMenuPilote
     * @param a
     */
    public DecorateurMenuPilote(Abstraction a) {
            super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO,"2 --> Saisir un rapport de vol");
        log.log(Level.INFO,"3 --> Retour au menu précèdent...");
    }
}
