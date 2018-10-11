package systeme;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import data_access_object.DAOFactory;
import data_access_object.PassagerDAO;
import data_access_object.PersonnelDAO;
import data_access_object.RoleNavigantDAO;
import data_access_object.RoleNonNavigantDAO;
import data_model.Passager;
import data_model.Personnel;
import data_model.RoleNavigant;
import data_model.RoleNonNavigant;

public class SystemeGestionUtilisateur {

	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	private Connection conn;
	private Personnel utilisateurConnecte = null;
	private List<String> typeUtilisateur;
	private DAOFactory factory;
	
	public SystemeGestionUtilisateur(Connection conn) {
		this.conn = conn;
		this.typeUtilisateur = new ArrayList<>();
		this.factory = new DAOFactory(conn);
	}
	
	public boolean connexion(int id, String mdp) {

		return true;
	}

	public boolean deconnexion() {
		if(utilisateurConnecte==null)
			return false;
		utilisateurConnecte = null;
		typeUtilisateur.clear();
		return true;
	}
	
	public Personnel getUtilisateurConnecte() {
		return utilisateurConnecte;
	}
	
	public List<String> getTypeUtilisateur(){
		return typeUtilisateur;
	}

	
	public boolean ajouterUtilisateur(String nom, String prenom, String adresse, BigInteger noTelephone, String type) {
		
		return true;
	}
	
	public boolean isEmailAdress(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher= pattern.matcher(email);
		return matcher.matches();
	}


}
