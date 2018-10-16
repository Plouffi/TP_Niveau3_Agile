package data_access_object;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import data_model.Role;
import data_model.TypeAvion;

public abstract class DAO<T> {

	protected Connection connexion;

	DAO(Connection connexion) {
		this.connexion = connexion;
	}
	
	public abstract boolean create(T obj) throws SQLException;
	
	public abstract boolean delete(T obj) throws SQLException;
	
	public abstract boolean update(T obj) throws SQLException;
	
	/* 
	 * nous sommes oblig�s de placer un type g�n�rique en param�tre de la fonction 
	 * car l'identifiant des tables est diff�rent selon les tables  
	 * */
	public abstract T find(T obj) throws SQLException;
	
}
