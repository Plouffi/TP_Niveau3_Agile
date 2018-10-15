package systeme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import data_access_object.AvionDAO;
import data_access_object.DAOFactory;
import data_model.Avion;
import data_model.Personnel;
import data_model.TypeAvion;

public class SystemeGestionAvion {

	private DAOFactory factory;
	
	public SystemeGestionAvion(Connection conn) {
		factory = new DAOFactory(conn);
	}

	public boolean ajouterAvion(Avion a) {
		try {
			return factory.createAvionDAO().create(a);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	public boolean ajouterTypeAvion(TypeAvion typeAvion) {
		try {
			return factory.createTypeAvionDAO().create(typeAvion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	public boolean supprimerAvion(Avion avion) {
		try {
			return factory.createAvionDAO().delete(avion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	public boolean supprimerTypeAvion(TypeAvion typeAvion) {
		try {
			if(((AvionDAO)factory.createAvionDAO()).findType(typeAvion))
				throw new SQLException("Le type est encore attribué il est donc non supprimable.");
			return factory.createTypeAvionDAO().delete(typeAvion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}

	public Avion rechercherAvion(Avion avion) {
		try {
			return factory.createAvionDAO().find(avion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return null;
	}

	public boolean majAvion(Avion avion) {
		try {
			return factory.createAvionDAO().update(avion);
		} catch (SQLException e) {
			Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
			logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
		}
		return false;
	}
}
