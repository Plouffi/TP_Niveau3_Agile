package state;

import decorator.DecorateurMenuGestionnaire;
import decorator.Implementation;

public class EtatMenuGestionnaire implements Etat{

	@Override
	public void goNext(Contexte c) {
    	Implementation i = new Implementation();
        DecorateurMenuGestionnaire d = new DecorateurMenuGestionnaire(i);
        d.affichage();
	}

}
