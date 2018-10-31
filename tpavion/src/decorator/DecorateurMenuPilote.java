package decorator;

public class DecorateurMenuPilote extends Decorateur {
    /**
     * Constructeur d'un DecorateurMenuPilote
     * @param a
     */
    public DecorateurMenuPilote(Abstraction a) {
            super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        System.out.println(" --> Saisir un rapport de vol");
        System.out.println(" --> Retour au menu précèdent...");
    }
}
