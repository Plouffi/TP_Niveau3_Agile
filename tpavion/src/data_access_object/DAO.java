package data_access_object;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import data_model.Role;
import data_model.TypeAvion;

public abstract class DAO<T> {

	protected Connection connexion;

	/**
	 * Constructeur de la classe g�n�rique, Toutes les m�thodes utilise connexion
	 * @param connexion
	 */
	DAO(Connection connexion) {
		this.connexion = connexion;
	}

	/**
	 * Fonction abstraite qui permettra l'insertion d'un objet dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	public abstract boolean create(T obj) throws SQLException;

	/**
	 * Fonction abstraite qui permettra la suppression d'un objet dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	public abstract boolean delete(T obj) throws SQLException;

	/**
	 * Fonction abstraite qui permettra la mise � jour d'un objet dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	public abstract boolean update(T obj) throws SQLException;

	/**
	 * Fonction abstraite qui permettra la r�cup�ration d'un objet dans la base de donn�es
	 * @param obj
	 * @return T
	 * @throws SQLException
	 */
	public abstract T find(T obj) throws SQLException;
	
}
