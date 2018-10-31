package decorator;

import data_model.Personnel;

public class DecorateurModificationPersonnel extends DecorateurPersonnel {

    private final Abstraction a;
    private Personnel personnel;

    /**
     * Constructeur d'un DecorateurModificationPersonnel
     * @param a
     * @param personnel
     */
    public DecorateurModificationPersonnel(Abstraction a, Personnel personnel) {
        super(a);
        this.a = a;
        this.personnel = personnel;
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        System.out.println(" 4 --> Modifier le nom (nom actuel : "+personnel.getNom()+" )");
        System.out.println(" 5 --> Modifier le prenom (prenom actuel : "+personnel.getPrenom()+" )");
        System.out.println(" 6 --> Modifier l'adresse (adresse actuelle : "+personnel.getAdresse()+" )");
        System.out.println(" 7 --> Modifier le num�ro de téléphone (numéro actuel : "+personnel.getNoTelephone()+" )");
        System.out.println(" 8 --> Modifier le type et le rôle (type actuel : "+personnel.getRole().getType().getType()+", r�le actuel : "+personnel.getRole().getRole()+" )");
    }
}
