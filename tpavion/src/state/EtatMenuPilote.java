package state;

import decorator.DecorateurMenuPilote;
import decorator.Implementation;

public class EtatMenuPilote implements Etat {

	@Override
	public void goNext(Contexte c) {
    	Implementation i = new Implementation();
        DecorateurMenuPilote d = new DecorateurMenuPilote(i);
        d.affichage();
	}

}
