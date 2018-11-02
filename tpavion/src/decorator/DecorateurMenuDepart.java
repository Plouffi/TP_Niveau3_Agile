package decorator;

public class DecorateurMenuDepart extends Decorateur{
    /**
     * Constructeur d'un DecorateurMenuDepart
     * @param a
     */
    public DecorateurMenuDepart(Abstraction a) {
        super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        System.out.println(" 2 --> Ajouter un nouveau départ");
        System.out.println(" 3 --> Modifier un départ existant");
        System.out.println(" 4 --> Supprimer un départ existant");
        System.out.println(" 5 --> Rechercher un départ existant");
        System.out.println(" 6 --> Programmer un vol en un départ :");
        System.out.println(" 7 --> Modifier la programmation d'un départ existant :");
        System.out.println(" 8 --> Supprimer la programmation d'un départ existant :");
        System.out.println(" 9 --> Rechercher la programmation d'un depart existant :");
        System.out.println(" 10 --> Programmer un passager pour un départ :");
        System.out.println(" 11 --> Modifier la programmation du départ d'un passager :");
        System.out.println(" 12 --> Supprimer la programmation du départ d'un passager :");
        System.out.println(" 13 --> Rechercher la programmation du départ d'un passager :");
        System.out.println(" 14 -> Retour au menu précèdent...");
    }
}