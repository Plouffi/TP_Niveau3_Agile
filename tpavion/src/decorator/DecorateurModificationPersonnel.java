package decorator;

import java.util.ArrayList;
import java.util.List;

import data_model.Personnel;
import data_model.Role;

public class DecorateurModificationPersonnel extends Decorateur {

	private Personnel personnel;
	private ArrayList<Role> roles;


	public DecorateurModificationPersonnel(Abstraction a,Personnel personnel, List<Role> roles) {
		super(a);
		this.personnel = personnel;
		this.roles = new ArrayList<>(roles);
	}

	@Override
	public void affichage() {
		a.affichage();
		System.out.println("3 --> Modifier le nom (nom actuel : "+personnel.getNom()+" )");
		System.out.println("4 --> Modifier le prenom (prenom actuel : "+personnel.getPrenom()+" )");
		System.out.println("5 --> Modifier l'adresse (adresse actuelle : "+personnel.getAdresse()+" )");
		System.out.println("6 --> Modifier le num�ro de t�l�phone (num�ro actuel : "+personnel.getNoTelephone()+" )");
		System.out.println("7 --> Modifier le type et le r�le (type actuel : "+personnel.getRole().getType().getType()+", r�le actuel : "+personnel.getRole().getRole()+" )");
	}
	
	public void affichageListeRoles() {
		for(int i = 0; i<roles.size();i++) {
			System.out.println((i+1)+" --> "+roles.get(i).getType()+" - "+roles.get(i).getRole());
		}
	}
	
	public void affichageTypeRole() {
		System.out.println(" Type de r�le ");
		System.out.println(" 1 --> Navigant");
		System.out.println(" 2 --> Non navigant");
	}
}
