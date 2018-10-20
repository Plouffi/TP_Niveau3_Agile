package state;


import data_model.Personnel;

import java.util.List;

public abstract class EtatPersonnel extends Etat{

    public String creerType(int t){
        String type="";
        switch(t) {
            case 1:
                type = "navigant";
                break;
            case 2:
                type = "nonnavigant";
                break;
            default :
                System.out.println("Erreur de saisie");
                break;
        }
        return type;
    }

    public void afficherPersonnels(List<Personnel> personnel) {
        for (Personnel p : personnel)
            System.out.println(p);
    }
}
