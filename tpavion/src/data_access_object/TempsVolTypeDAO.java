package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.TempsVolType;

public class TempsVolTypeDAO extends DAO<TempsVolType> {
	/**
	 * Constructeur appelant le constructeur de la super classe
	 * @param connexion
	 */
	TempsVolTypeDAO(Connection connexion) {
		super(connexion);
	}

	/**
	 * Fonction permettant l'insertion d'un TempsVolType dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean create(TempsVolType obj) throws SQLException {
		String requete ="insert into TempsVolType values (?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setInt(2, obj.getType());
			statement.setTime(3, obj.getNombreHeure());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la suppression d'un TempsVolType existant dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean delete(TempsVolType obj) throws SQLException {
		String requete ="delete from TempsVolType where pilote=? and typeAvion=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setInt(2, obj.getType());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la mise � jour d'un TempsVolType existant dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean update(TempsVolType obj) throws SQLException {
		String requete ="update TempsVolType set nombreHeure=? where id=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setTime(1, obj.getNombreHeure());
			statement.setInt(2, obj.getId());
			statement.setInt(3, obj.getType());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la r�cup�ration d'un TempsVolType existant dans la base de donn�es en utilisant l'identifiant du pilote et
	 * le type d'avion
	 * @param obj
	 * @return tempsvoltype
	 * @throws SQLException
	 */
	@Override
	public TempsVolType find(TempsVolType obj) throws SQLException {
		String requete = "select * from TempsVolType where id=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setInt(2, obj.getType());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
		        	return new TempsVolType(result.getInt("id"),result.getInt("type"),result.getTime("nombreHeure"));
				return null;
			}
		}
	}

}
