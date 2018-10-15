package decorator;

import data_model.Personnel;

public class DecorateurModificationPersonnel extends Decorateur {

	private Personnel personnel;

	public DecorateurModificationPersonnel(Abstraction a,Personnel personnel) {
		super(a);
		this.personnel = personnel;
	}

	@Override
	public void affichage() {
		a.affichage();
		System.out.println("3 --> Modifier le nom (nom actuel : "+personnel.getNom()+" )");
		System.out.println("4 --> Modifier le prenom (prenom actuel : "+personnel.getPrenom()+" )");
		System.out.println("5 --> Modifier l'adresse (adresse actuelle : "+personnel.getAdresse()+" )");
		System.out.println("6 --> Modifier le num�ro de t�l�phone (num�ro actuel : "+personnel.getNoTelephone()+" )");
		System.out.println("7 --> Modifier le type et le r�le (type actuel : "+personnel.getType().getType()+", r�le actuel : "+personnel.getRole()+" )");
	}

}
