package data_access_object;

import java.sql.Connection;

import data_model.Avion;
import data_model.Depart;
import data_model.DepartAvion;
import data_model.DepartPassager;
import data_model.Passager;
import data_model.Personnel;
import data_model.Pilote;
import data_model.RapportPilote;
import data_model.Role;
import data_model.TempsVolType;
import data_model.Troncon;
import data_model.TypeAvion;
import data_model.Vol;
import data_model.VolTroncon;


public class DAOFactory {
	
	Connection connexion;

	public DAOFactory(Connection connexion) {
		this.connexion = connexion;
	}
	
	public DAO<Avion> createAvionDAO() {
		return new AvionDAO(connexion);
	}

	public DAO<DepartAvion> createDepartAvionDAO() {
		return new DepartAvionDAO(connexion);
	}
	
	public DAO<Depart> createDepartDAO() {
		return new DepartDAO(connexion);
	}
	
	public DAO<DepartPassager> createDepartPassagerDAO() {
		return new DepartPassagerDAO(connexion);
	}
	
	public DAO<Passager> createPassagerDAO() {
		return new PassagerDAO(connexion);
	}
	
	public DAO<Personnel> createPersonnelDAO() {
		return new PersonnelDAO(connexion);
	}
	
	public DAO<Pilote> createPiloteDAO() {
		return new PiloteDAO(connexion);
	}
	
	public DAO<RapportPilote> createRapportPiloteDAO() {
		return new RapportPiloteDAO(connexion);
	}
	
	public DAO<TempsVolType> createTempsVolTypeDAO() {
		return new TempsVolTypeDAO(connexion);
	}
	
	public DAO<Troncon> createTronconDAO() {
		return new TronconDAO(connexion);
	}
	
	public DAO<TypeAvion> createTypeAvionDAO() {
		return new TypeAvionDAO(connexion);
	}
	
	public DAO<Role> createRoleDAO() {
		return new RoleDAO(connexion);
	}

	public DAO<Vol> createVolDAO() {
		return new VolDAO(connexion);
	}
	
	public DAO<VolTroncon> createVolTronconDAO() {
		return new VolTronconDAO(connexion);
	}
}
