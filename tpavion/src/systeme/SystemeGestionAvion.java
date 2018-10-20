package systeme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import data_access_object.AvionDAO;
import data_access_object.DAOFactory;
import data_access_object.PersonnelDAO;
import data_access_object.TypeAvionDAO;
import data_model.Avion;
import data_model.TypeAvion;

public class SystemeGestionAvion {

	private DAOFactory factory;

	/**
	 * Constructeur du Systeme de Gestion des avions
	 * @param conn
	 */
	public SystemeGestionAvion(Connection conn) {
		factory = new DAOFactory(conn);
	}

	/**
	 * M�thode permettant l'ajout d'un avion
	 * @param a
	 * @return boolean
	 */
	public boolean ajouterAvion(Avion a) {
		try {
			return factory.createAvionDAO().create(a);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	/**
	 * M�thode permettant l'ajout d'un type d'avion
	 * @param typeAvion
	 * @return boolean
	 */
	public boolean ajouterTypeAvion(TypeAvion typeAvion) {
		try {
			return factory.createTypeAvionDAO().create(typeAvion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	/**
	 * M�thode permettant la suppression d'un avion
	 * @param avion
	 * @return boolean
	 */
	public boolean supprimerAvion(Avion avion) {
		try {
			return factory.createAvionDAO().delete(avion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	/**
	 * M�thode permettant la suppression d'un avion
	 * @param typeAvion
	 * @return boolean
	 */
	public boolean supprimerTypeAvion(TypeAvion typeAvion) {
		try {
			if(((AvionDAO)factory.createAvionDAO()).findType(typeAvion))
				throw new SQLException("Le type est encore attribu� il est donc non supprimable.");
			return factory.createTypeAvionDAO().delete(typeAvion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	/**
	 * M�thode permettant de voir si un avion existe dans la base de donn�es
	 * @param avion
	 * @return avion
	 */
	public Avion rechercherAvion(Avion avion) {
		try {
			return factory.createAvionDAO().find(avion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionAvion.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return null;
	}

	/**
	 * M�thode mettant � jour un avion
	 * @param avion
	 * @return
	 */
	public boolean majAvion(Avion avion) {
		try {
			return factory.createAvionDAO().update(avion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	public List<TypeAvion> rechercherTypes() {
		try {
			return ((TypeAvionDAO) factory.createTypeAvionDAO()).findAll();
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionAvion.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return new ArrayList<>();
	}

	public List<Avion> rechercherAvions(){
		try {
			return ((AvionDAO) factory.createAvionDAO()).findAll();
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionAvion.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return new ArrayList<>();
	}
}
