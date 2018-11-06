package decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import data_model.Role;

public class DecorateurMenuPersonnel extends DecorateurPersonnel {

    private ArrayList<Role> roles;

    /**
     * Constructeur d'un DecorateurMenuPersonnel
     * @param a
     * @param roles
     */
    public DecorateurMenuPersonnel(Abstraction a, List<Role> roles) {
        super(a);
        this.roles = new ArrayList<>(roles);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 3 --> Ajouter un nouvel utilisateur");
        log.log(Level.INFO," 4 --> Ajouter un nouveau rôle");
        log.log(Level.INFO," 5 --> Modifier un utilisateur existant");
        log.log(Level.INFO," 6 --> Supprimer un utilisateur existant");
        log.log(Level.INFO," 7 --> Retour au menu précèdent...");
    }

    /**
     * méthode permettant d'afficher la liste de réle
     */
    
    public void affichageListeRoles() {
        for(int i = 0; i<roles.size();i++) {
        	String chaine =(i+1)+" --> {0}"+roles.get(i).getType()+" - "+roles.get(i).getRole();
        	log.log(Level.INFO,chaine);
        }
    }

}
