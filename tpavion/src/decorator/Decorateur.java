package decorator;

/**
 * The Class Decorateur.
 */
public abstract class Decorateur implements Abstraction{
	  
  	/** The a. */
  	Abstraction a;

	/**
	 * Constructeur de la m�thode abstraite "Decorateur".
	 *
	 * @param a the a
	 */
	public Decorateur(Abstraction a){
	      this.a = a;
	  }
}
