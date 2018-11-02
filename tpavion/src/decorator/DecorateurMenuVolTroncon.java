package decorator;

public class DecorateurMenuVolTroncon extends Decorateur{
    /**
     * Constructeur d'un DecorateurMenuVolTroncon
     * @param a
     */
    public DecorateurMenuVolTroncon(Abstraction a) {
            super(a);
    }

    /**
     * Méthode permettant l'affichage du menu
     */
    @Override
    public void affichage() {
        a.affichage();
        System.out.println(" 2 --> Ajouter un nouveau vol");
        System.out.println(" 3 --> Modifier un vol existant");
        System.out.println(" 4 --> Supprimer un vol existant");
        System.out.println(" 5 --> Rechercher un vol existant");
        System.out.println(" 6 --> Ajouter un nouveau tron�on");
        System.out.println(" 7 --> Modifier un tronçon existant");
        System.out.println(" 8 --> Supprimer un tronçon existant");
        System.out.println(" 9 --> Rechercher un tronçon existant");
        System.out.println(" 10 --> Associer un vol à un troncon");
        System.out.println(" 11 --> Modifier une association vol-tronçon");
        System.out.println(" 12 --> Supprimer une association vol-tronçon (à faire avant de supprimer les vols / tronçon)");
        System.out.println(" 13 --> Rechercher une association vol-tronçon");
        System.out.println(" 14 -> Retour au menu précèdent...");
    }
}