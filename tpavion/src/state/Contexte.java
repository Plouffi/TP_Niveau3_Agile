package state;

import systeme.SystemeGestion;

public class Contexte {

    private Etat prec;
    private Etat courant;
    private SystemeGestion element;
    
    public void goNext()
    {
        courant.goNext(this);
    }
    
    public void setState(Etat e)
    {       
        prec = courant;
        courant = e;
        goNext();
    }
    
    public void setElement(SystemeGestion element)
    {
        this.element = element;
    }
    
    public SystemeGestion getElement()
    {
        return element;
    }

    public Etat getPrec() 
    {
        return prec;
    }
    
    
}
