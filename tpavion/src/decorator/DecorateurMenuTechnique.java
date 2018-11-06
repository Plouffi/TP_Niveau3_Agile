package decorator;

import java.util.logging.Level;

public class DecorateurMenuTechnique extends DecorateurTechnique {
    /**
     * Constructeur d'un DecorateurMenuTechnique
     * @param a
     */
    public DecorateurMenuTechnique(Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Ajouter un nouvel avion");
        log.log(Level.INFO," 4 --> Ajouter un nouveau type d'avion");
        log.log(Level.INFO," 5 --> Modifier un avion existant");
        log.log(Level.INFO," 6 --> Supprimer un avion existant");
        log.log(Level.INFO," 7 --> Supprimer un type d'avion existant");
        log.log(Level.INFO," 8 --> Retour au menu précèdent...");
    }
}
