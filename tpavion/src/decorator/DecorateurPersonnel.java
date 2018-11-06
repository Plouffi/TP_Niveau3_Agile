package decorator;

import data_model.Personnel;
import data_model.Role;

import java.util.List;
import java.util.logging.Level;

public abstract class DecorateurPersonnel extends Decorateur{
    
    /**
     * Constructeur de la méthode abstraite "Decorateur".
     *
     * @param a the a
     */
    public DecorateurPersonnel(Abstraction a){
        super(a);
    }

    /**
     * Méthode permettant l'affichage de la liste des rôles
     * @param roles
     */
    public void affichageListeRoles(List<Role> roles) {
        for(int i = 0; i<roles.size();i++) {
        	String chaine= (i+1)+" --> "+roles.get(i).getType()+" - "+roles.get(i).getRole();
        	log.log(Level.INFO,chaine);
        }
    }

    /**
     * Méthode permettant l'affichage des types de rôles
     */
    public void affichageTypeRole() {
    	log.log(Level.INFO," Type de rôle ");
    	log.log(Level.INFO," 1 --> Navigant");
    	log.log(Level.INFO," 2 --> Non navigant");
    }
    
    /**
     * Méthode permettant l'affichage le personnel
     */
    public void afficherPersonnels(List<Personnel> personnel) {
        for (Personnel p : personnel)
        	log.log(Level.INFO,p.toString());
    }
}
