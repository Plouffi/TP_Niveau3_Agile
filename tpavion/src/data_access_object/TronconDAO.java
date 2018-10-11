package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Troncon;

public class TronconDAO extends DAO<Troncon, Integer, Troncon> {

	TronconDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Troncon obj) throws SQLException {
		String requete = "insert into Troncon values ('?','?','?');";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getVilleDepart());
			statement.setString(2, obj.getVilleArrivee());
			statement.setInt(3, obj.getDistance());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(Troncon obj) throws SQLException {
		String requete = "delete from Troncon where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			return statement.execute();
		}
	}

	@Override
	public boolean update(Troncon obj) throws SQLException {
		String requete = "update Troncon set villeDepart='?', villeArrivee='?', distance='?' where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getVilleDepart());
			statement.setString(2, obj.getVilleArrivee());
			statement.setInt(3, obj.getDistance());
			statement.setInt(4, obj.getId());
			return statement.execute();
		}
	}
	
	@Override
	public Troncon find(Integer id) throws SQLException {
		String requete = "select * from Troncon where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, id);
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
					return new Troncon(result.getInt("id"),result.getString("villeDepart"),result.getString("villeArrivee"),result.getInt("distance"));
				return null;
			}
		}
	}

}
