package state;

import data_model.Avion;

import java.util.List;

public abstract class EtatTechnique extends Etat{

    public void afficherAvions(List<Avion> avions){
        for(Avion a : avions)
            System.out.println(a);
    }
}
