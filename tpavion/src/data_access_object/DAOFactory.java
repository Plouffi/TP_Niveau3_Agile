package data_access_object;

import java.sql.Connection;


public class DAOFactory {
	
	Connection connexion;

	public DAOFactory(Connection connexion) {
		this.connexion = connexion;
	}
	
	public AvionDAO createAvionDAO() {
		return new AvionDAO(connexion);
	}

	public DepartAvionDAO createDepartAvionDAO() {
		return new DepartAvionDAO(connexion);
	}
	
	public DepartDAO createDepartDAO() {
		return new DepartDAO(connexion);
	}
	
	public DepartPassagerDAO createDepartPassagerDAO() {
		return new DepartPassagerDAO(connexion);
	}
	
	public PassagerDAO createPassagerDAO() {
		return new PassagerDAO(connexion);
	}
	
	public PassagerDAO createPersonneDAO() {
		return new PassagerDAO(connexion);
	}
	
	public PersonnelDAO createPersonnelDAO() {
		return new PersonnelDAO(connexion);
	}
	
	public PiloteDAO createPiloteDAO() {
		return new PiloteDAO(connexion);
	}
	
	public RapportPiloteDAO createRapportPiloteDAO() {
		return new RapportPiloteDAO(connexion);
	}
	
	public TempsVolTypeDAO createTempsVolTypeDAO() {
		return new TempsVolTypeDAO(connexion);
	}
	
	public TronconDAO createTronconDAO() {
		return new TronconDAO(connexion);
	}
	
	public TypeAvionDAO createTypeAvionDAO() {
		return new TypeAvionDAO(connexion);
	}
	
	public RoleNavigantDAO createTypeNavigantDAO() {
		return new RoleNavigantDAO(connexion);
	}
	
	public RoleNonNavigantDAO createTypeNonNavigantDAO() {
		return new RoleNonNavigantDAO(connexion);
	}
	
	public VolDAO createVolDAO() {
		return new VolDAO(connexion);
	}
	
	public VolTronconDAO createVolTronconDAO() {
		return new VolTronconDAO(connexion);
	}
}
