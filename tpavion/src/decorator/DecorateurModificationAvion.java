package decorator;

import java.util.logging.Level;

import data_model.Avion;

public class DecorateurModificationAvion extends DecorateurTechnique{

    private Avion avion = null;

    /**
     * Constructeur d'un DecorateurModificationAvion
     * @param a
     * @param avion
     */
    public DecorateurModificationAvion(Abstraction a) {
        super(a);
    }
    
    public void setAvion(Avion avion){
        this.avion = avion;
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Modifier la capacité (capacite actuelle : "+avion.getCapacite()+" )");
        log.log(Level.INFO," 4 --> Modifier le type (type actuel : "+avion.getType()+" )");
    }
}
