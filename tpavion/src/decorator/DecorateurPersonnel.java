package decorator;

import data_model.Role;

import java.util.List;

public abstract class DecorateurPersonnel implements Abstraction{
    Abstraction a;

     public DecorateurPersonnel(Abstraction a){
         this.a = a;
     }


    /**
     * Méthode permettant l'affichage de la liste des rôles
     * @param roles
     */
    public void affichageListeRoles(List<Role> roles) {
        for(int i = 0; i<roles.size();i++) {
            System.out.println((i+1)+" --> "+roles.get(i).getType()+" - "+roles.get(i).getRole());
        }
    }

    /**
     * Méthode permettant l'affichage des types de rôles
     */
    public void affichageTypeRole() {
        System.out.println(" Type de rôle ");
        System.out.println(" 1 --> Navigant");
        System.out.println(" 2 --> Non navigant");
    }
}
