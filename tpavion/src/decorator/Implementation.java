package decorator;

public class Implementation implements Abstraction {

	@Override
	public void affichage()
    {
       // affichage commun a tous les decorateurs
       System.out.println("----------MENU-----------");
       System.out.println(" --> Déconnexion");
    }

}
