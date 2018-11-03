package decorator;

import data_model.Role;
import data_model.TypeAvion;

import java.util.List;

public abstract class DecorateurTechnique extends Decorateur {
    /**
     * Constructeur de la méthode abstraite "Decorateur".
     *
     * @param a the a
     */
    public DecorateurTechnique(Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage de la liste des rôles
     */
    public void affichageListeType(List<TypeAvion> types) {
        for(int i = 0; i<types.size();i++) {
            System.out.println((i+1)+" --> "+types.get(i).getType());
        }
    }
}
