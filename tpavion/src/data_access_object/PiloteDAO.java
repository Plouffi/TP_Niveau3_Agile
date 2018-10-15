package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Pilote;

public class PiloteDAO extends DAO<Pilote> {

	PiloteDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Pilote obj) throws SQLException {
		String requete ="insert into pilote values (?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setTime(2, obj.getNombreHeureTotale());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delete(Pilote obj) throws SQLException {
		String requete = "delete from pilote where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean update(Pilote obj) throws SQLException {
		String requete ="update pilote set nombreHeureTotale=? where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setTime(1, obj.getNombreHeureTotale());
			statement.setInt(2, obj.getId());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public Pilote find(Pilote obj) throws SQLException {
		String requete = "select * from pilote where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
		        	return new Pilote(result.getInt("id"),result.getTime("nombreHeureTotale"));
				return null;
			}
		}
	}

}
