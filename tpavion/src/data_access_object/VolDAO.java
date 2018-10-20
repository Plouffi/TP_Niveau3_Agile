package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Vol;

public class VolDAO extends DAO<Vol> {

	/**
	 * Constructeur appelant le constructeur de la super classe
	 * @param connexion
	 */
	VolDAO(Connection connexion) {
		super(connexion);
	}

	/**
	 * Fonction permettant l'insertion d'un Vol dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean create(Vol obj) throws SQLException {
		String requete = "insert into Vol values (?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getFrequence());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la suppression d'un Vol existant dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean delete(Vol obj) throws SQLException {
		String requete = "delete from Vol where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la mise � jour d'un Vol existant dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean update(Vol obj) throws SQLException {
		String requete = "update Vol set frequence=? where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getFrequence());
			statement.setInt(2, obj.getId());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la r�cup�ration d'un Vol existant dans la base de donn�es en utilisant son identifiant
	 * @param obj
	 * @return vol
	 * @throws SQLException
	 */
	@Override
	public Vol find(Vol obj) throws SQLException {
		String requete ="select * from Vol where id=?";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
		        	return new Vol(result.getInt("id"),result.getInt("frequence"));
				return null;
			}
		}
	}

}
