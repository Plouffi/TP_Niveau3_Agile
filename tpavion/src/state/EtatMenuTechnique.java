package state;

import decorator.DecorateurMenuTechnique;
import decorator.Implementation;

public class EtatMenuTechnique implements Etat {

	@Override
	public void goNext(Contexte c) {
    	Implementation i = new Implementation();
        DecorateurMenuTechnique d = new DecorateurMenuTechnique(i);
        d.affichage();
    }

}
