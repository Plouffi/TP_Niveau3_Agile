package decorator;

public class Implementation implements Abstraction {

    /**
     * Méthode permettant l'affichage du menu
     */
	@Override
	public void affichage()
    {
       // affichage commun a tous les decorateurs
       System.out.println("----------MENU-----------");
       System.out.println(" 1 --> Déconnexion");
    }

}
