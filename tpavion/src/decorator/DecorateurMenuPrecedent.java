package decorator;

public class DecorateurMenuPrecedent extends Decorateur{
    /**
     * Constructeur d'un DecorateurNonNavigant
     * @param a
     */
    public DecorateurMenuPrecedent(Abstraction a) {
        super(a);
    }

    /**
     * M�thode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        System.out.println(" 3 --> Retour au menu pr�c�dent");

    }

}
