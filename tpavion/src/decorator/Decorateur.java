package decorator;

import java.util.logging.Logger;

/**
 * The Class Decorateur.
 */
public abstract class Decorateur implements Abstraction{
	Logger log = Logger.getLogger(getClass().getName());
    /** The a. */
    Abstraction a;

    /**
     * Constructeur de la méthode abstraite "Decorateur".
     *
     * @param a the a
     */
    public Decorateur(Abstraction a){
          this.a = a;
    }
}
