package state;

public interface Etat 
{    
    void goNext(Contexte c);
    // m�thode qui sera utilis�e pour effectuer des actions et si il y a des �tats
    // qui suivent l'etat courant alors on d�terminera l'etat suivant dans cette m�thode
}
