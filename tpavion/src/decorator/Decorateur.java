package decorator;

public abstract class Decorateur implements Abstraction{
	  Abstraction a;
	    
	  public Decorateur(Abstraction a){
	      this.a = a;
	  }
}
