package decorator;

public class DecorateurMenuConnecte extends Decorateur{
    public DecorateurMenuConnecte (Abstraction a) {
        super(a);
    }
    
    @Override
    public void affichage() 
    {
        a.affichage(); // affichage de l'abstraction.
        /* a voir plus tard en fonction des droits de l'utilisateur (menuGestion)*/
        System.out.println(" --> Menu Personnel");
		System.out.println(" --> Menu Gestionnaire");
		System.out.println(" --> Menu Technique");
		System.out.println(" --> Menu Pilote");
    }
}
