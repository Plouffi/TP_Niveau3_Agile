package systeme;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;

import data_access_object.DAO;
import data_access_object.PersonnelDAO;
import data_access_object.RoleDAO;
import data_access_object.DAOFactory;
import data_model.Personnel;
import data_model.Role;
import data_model.TypeRole;

public class SystemeGestionUtilisateur {

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

		DAO<Personnel> personnelDAO = factory.createPersonnelDAO();
		try {
			utilisateurConnecte =((PersonnelDAO) personnelDAO).findConnection(id,mdp);
			return (utilisateurConnecte!= null);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
		
	}

	public void deconnexion() {
		utilisateurConnecte = null;
		typeUtilisateur.clear();
	}
	
	public Personnel getUtilisateurConnecte() {
		return utilisateurConnecte;
	}
	
	public List<String> getTypeUtilisateur(){
		return typeUtilisateur;
	}

	
	public boolean ajouterUtilisateur(Personnel personnel) {
		DAO<Personnel> personnelDAO = factory.createPersonnelDAO();
		try {
			return personnelDAO.create(personnel);
		}
		catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}


	private String encoderMessage(String message) {
		byte[] byteChaine = null;
		MessageDigest md=null;
		try {
			byteChaine = message.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] hash = md.digest(byteChaine);
		return hash.toString();
	}

	public boolean ajouterRole(Role role) {
		DAO<Role> roleDAO = factory.createRoleDAO();
		try {
			return roleDAO.create(role);
		}
		catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;	
		
	}

	public boolean supprimerUtilisateur(Personnel personnel) {
		DAO<Personnel> personnelDAO = factory.createPersonnelDAO();
		try {
			return personnelDAO.delete(personnel);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
		
	}

	public Personnel rechercherUtilisateur(Personnel personnel) {
		try {
			return factory.createPersonnelDAO().find(personnel);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return null;
	}

	public boolean majUtilisateur(Personnel personnel) {
		try {
			return factory.createPersonnelDAO().update(personnel);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
		
	}
	
	public List<Role> getRoles(){
		try {
			return ((RoleDAO) factory.createRoleDAO()).findRoles();
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return new ArrayList<>();
	}

}
