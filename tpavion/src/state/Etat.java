package state;

public interface Etat 
{    
    void goNext(Contexte c);
    // méthode qui sera utilisée pour effectuer des actions et si il y a des états
    // qui suivent l'etat courant alors on déterminera l'etat suivant dans cette méthode
}
