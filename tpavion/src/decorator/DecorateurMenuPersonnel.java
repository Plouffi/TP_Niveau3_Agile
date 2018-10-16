package decorator;

import java.util.ArrayList;
import java.util.List;

import data_model.Role;

public class DecorateurMenuPersonnel extends Decorateur {

	private ArrayList<Role> roles;

	public DecorateurMenuPersonnel(Abstraction a, List<Role> roles) {
		super(a);
		this.roles = new ArrayList<>(roles);
	}

	@Override
	public void affichage() {
		a.affichage();
		System.out.println(" 3 --> Ajouter un nouvel utilisateur");
		System.out.println(" 4 --> Ajouter un nouveau rôle");
		System.out.println(" 5 --> Modifier un utilisateur existant");
		System.out.println(" 6 --> Supprimer un utilisateur existant");
		System.out.println(" 7 --> Retour au menu précédent...");
	}

	public void affichageListeRoles() {
		for(int i = 0; i<roles.size();i++) {
			System.out.println((i+1)+" --> "+roles.get(i).getType()+" - "+roles.get(i).getRole());
		}
	}
	
	public void affichageTypeRole() {
		System.out.println(" Type de rôle ");
		System.out.println(" 1 --> Navigant");
		System.out.println(" 2 --> Non navigant");
	}
}
