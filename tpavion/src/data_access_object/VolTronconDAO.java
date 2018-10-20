package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.VolTroncon;

public class VolTronconDAO extends DAO<VolTroncon> {

	/**
	 * Constructeur appelant le constructeur de la super classe
	 * @param connexion
	 */
	VolTronconDAO(Connection connexion) {
		super(connexion);
	}

	/**
	 * Fonction permettant l'insertion d'un VolTroncon dans la base de données
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean create(VolTroncon obj) throws SQLException {
		String requete = "insert into VolTroncon values (?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getTroncon());
			statement.setInt(2, obj.getVol());
			statement.setTime(3, obj.getHeureDepart());
			statement.setTime(4, obj.getHeureSortie());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la suppression d'un VolTroncon existant dans la base de données
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean delete(VolTroncon obj) throws SQLException {
		String requete = "delete from VolTroncon where troncon=? and vol=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getTroncon());
			statement.setInt(2, obj.getVol());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la mise à jour d'un VolTroncon existant dans la base de données
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean update(VolTroncon obj) throws SQLException {
		String requete = "update VolTroncon set heureDepart=?,heureSortie=? where troncon=? and vol=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setTime(1, obj.getHeureDepart());
			statement.setTime(2, obj.getHeureSortie());
			statement.setInt(3, obj.getTroncon());
			statement.setInt(4, obj.getVol());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la récupération d'un VolTroncon existant dans la base de données en utilisant l'identifiant du vol et l'identifiant du vol
	 * @param obj
	 * @return vol
	 * @throws SQLException
	 */
	@Override
	public VolTroncon find(VolTroncon obj) throws SQLException {
		String requete = "select * from VolTroncon where troncon=? and vol=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getTroncon());
			statement.setInt(2, obj.getVol());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
					return new VolTroncon(result.getInt("troncon"),result.getInt("vol"),result.getTime("heureDepart"),result.getTime("heureSortie"));
				return null;
			}
		}
	}

}
