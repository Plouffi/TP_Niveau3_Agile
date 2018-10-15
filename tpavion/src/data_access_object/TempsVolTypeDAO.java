package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.TempsVolType;

public class TempsVolTypeDAO extends DAO<TempsVolType> {

	TempsVolTypeDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(TempsVolType obj) throws SQLException {
		String requete ="insert into TempsVolType values (?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setInt(2, obj.getType());
			statement.setTime(3, obj.getNombreHeure());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delete(TempsVolType obj) throws SQLException {
		String requete ="delete from TempsVolType where pilote=? and typeAvion=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setInt(2, obj.getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean update(TempsVolType obj) throws SQLException {
		String requete ="update TempsVolType set nombreHeure=? where id=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setTime(1, obj.getNombreHeure());
			statement.setInt(2, obj.getId());
			statement.setInt(3, obj.getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

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
