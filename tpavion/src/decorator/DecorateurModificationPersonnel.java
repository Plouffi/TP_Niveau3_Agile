package decorator;

import java.util.logging.Level;

import data_model.Personnel;

public class DecorateurModificationPersonnel extends DecorateurPersonnel {

    private Personnel personnel = null;

    /**
     * Constructeur d'un DecorateurModificationPersonnel
     * @param a
     * @param personnel
     */
    public DecorateurModificationPersonnel(Abstraction a) {
        super(a);       
    }
    
    public void setPersonnel(Personnel personnel){
         this.personnel = personnel;
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        log.log(Level.INFO," 4 --> Modifier le nom (nom actuel : "+personnel.getNom()+" )");
        log.log(Level.INFO," 5 --> Modifier le prenom (prenom actuel : "+personnel.getPrenom()+" )");
        log.log(Level.INFO," 6 --> Modifier l'adresse (adresse actuelle : "+personnel.getAdresse()+" )");
        log.log(Level.INFO," 7 --> Modifier le numéro de téléphone (numéro actuel : "+personnel.getNoTelephone()+" )");
        log.log(Level.INFO," 8 --> Modifier le type et le rôle (type actuel : "+personnel.getRole().getType().getType()+", r�le actuel : "+personnel.getRole().getRole()+" )");
    }
}
