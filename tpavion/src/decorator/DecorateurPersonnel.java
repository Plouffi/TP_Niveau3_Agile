package decorator;

import data_model.Role;

import java.util.List;

public abstract class DecorateurPersonnel implements Abstraction{
    Abstraction a;

     public DecorateurPersonnel(Abstraction a){
         this.a = a;
     }


    /**
     * M�thode permettant l'affichage de la liste des r�les
     * @param roles
     */
    public void affichageListeRoles(List<Role> roles) {
        for(int i = 0; i<roles.size();i++) {
            System.out.println((i+1)+" --> "+roles.get(i).getType()+" - "+roles.get(i).getRole());
        }
    }

    /**
     * M�thode permettant l'affichage des types de r�les
     */
    public void affichageTypeRole() {
        System.out.println(" Type de r�le ");
        System.out.println(" 1 --> Navigant");
        System.out.println(" 2 --> Non navigant");
    }
}
