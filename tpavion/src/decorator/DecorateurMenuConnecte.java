package decorator;

import java.util.logging.Level;

public class DecorateurMenuConnecte extends Decorateur{
    /**
     * Constructeur du décorateur Menu Connecte
     * @param a
     */
    public DecorateurMenuConnecte (Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage(){
        a.affichage(); // affichage de l'abstraction.
        /* a voir plus tard en fonction des droits de l'utilisateur (menuGestion)*/
        log.log(Level.INFO," 2 --> Menu Personnel");
        log.log(Level.INFO," 3 --> Menu Gestionnaire");
        log.log(Level.INFO," 4 --> Menu Technique");
        log.log(Level.INFO," 5 --> Menu Pilote");
    }
}
