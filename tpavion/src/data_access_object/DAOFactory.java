package data_access_object;

import java.sql.Connection;

import data_model.*;


public class DAOFactory {
	
	Connection connexion;

	/**
	 * Constructeur de la Factory
	 * @param connexion
	 */
	public DAOFactory(Connection connexion) {
		this.connexion = connexion;
	}

	/**
	 * Cr�ation d'une instance d'avionDAO
	 * @return dao<Avion>
	 */
	public DAO<Avion> createAvionDAO() {
		return new AvionDAO(connexion);
	}
	/**
	 * Cr�ation d'une instance de DepartAvionDAO
	 * @return dao<DepartAvion>
	 */
	public DAO<DepartAvion> createDepartAvionDAO() {
		return new DepartAvionDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de DepartDAO
	 * @return dao<Depart>
	 */
	public DAO<Depart> createDepartDAO() {
		return new DepartDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de DepartPassagerDAO
	 * @return dao<DepartPassager>
	 */
	public DAO<DepartPassager> createDepartPassagerDAO() {
		return new DepartPassagerDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de PassagerDAO
	 * @return dao<Passager>
	 */
	public DAO<Passager> createPassagerDAO() {
		return new PassagerDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de PersonnelDAO
	 * @return dao<Personnel>
	 */
	public DAO<Personnel> createPersonnelDAO() {
		return new PersonnelDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de PersonnelDAO
	 * @return dao<Avion>
	 */
	public DAO<Pilote> createPiloteDAO() {
		return new PiloteDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de RapportPiloteDAO
	 * @return dao<RapportPilote>
	 */
	public DAO<RapportPilote> createRapportPiloteDAO() {
		return new RapportPiloteDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de TempsVolTypeDAO
	 * @return dao<TempsVolType>
	 */
	public DAO<TempsVolType> createTempsVolTypeDAO() {
		return new TempsVolTypeDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de TronconDAO
	 * @return dao<Troncon>
	 */
	public DAO<Troncon> createTronconDAO() {
		return new TronconDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de TypeAvionDAO
	 * @return dao<TypeAvion>
	 */
	public DAO<TypeAvion> createTypeAvionDAO() {
		return new TypeAvionDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de RoleDAO
	 * @return dao<Role>
	 */
	public DAO<Role> createRoleDAO() {
		return new RoleDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de VolDAO
	 * @return dao<Vol>
	 */
	public DAO<Vol> createVolDAO() {
		return new VolDAO(connexion);
	}

	/**
	 * Cr�ation d'une instance de VolTronconDAO
	 * @return dao<VolTroncon>
	 */
	public DAO<VolTroncon> createVolTronconDAO() {
		return new VolTronconDAO(connexion);
	}
}
