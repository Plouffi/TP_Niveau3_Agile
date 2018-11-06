package decorator;

import java.util.logging.Level;

public class DecorateurMenuVolTroncon extends Decorateur{
    /**
     * Constructeur d'un DecorateurMenuVolTroncon
     * @param a
     */
    public DecorateurMenuVolTroncon(Abstraction a) {
            super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Ajouter un nouveau vol");
        log.log(Level.INFO," 4 --> Modifier un vol existant");
        log.log(Level.INFO," 5 --> Supprimer un vol existant");
        log.log(Level.INFO," 6 --> Rechercher un vol existant");
        log.log(Level.INFO," 7 --> Ajouter un nouveau tron�on");
        log.log(Level.INFO," 8 --> Modifier un tronçon existant");
        log.log(Level.INFO," 9 --> Supprimer un tronçon existant");
        log.log(Level.INFO," 10 --> Rechercher un tronçon existant");
        log.log(Level.INFO," 11 --> Associer un vol à un troncon");
        log.log(Level.INFO," 12 --> Modifier une association vol-tronçon");
        log.log(Level.INFO," 13 --> Supprimer une association vol-tronçon");
        log.log(Level.INFO," 14 --> Rechercher une association vol-tronçon");
        log.log(Level.INFO," 15 -> Retour au menu précèdent...");
    }
}