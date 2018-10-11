package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data_model.Avion;

public class AvionDAO extends DAO<Avion, Integer, Avion> {

	AvionDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Avion obj) throws SQLException {
	    String requete =
	        "insert into avion (immatriculation,capacite,typeAvion)" +
	        "values (?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getImmatriculation());
			statement.setInt(2, obj.getCapacite());
			statement.setString(3, obj.getType());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(Avion obj) throws SQLException {
	    String requete =
	        "delete from avion where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getImmatriculation());
			return statement.execute();
		}
	}

	@Override
	public boolean update(Avion obj) throws SQLException {
	    String requete =
	    		"update avion set typeAvion='?', capacite='?' where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getCapacite());
			statement.setString(2, obj.getType());
			statement.setString(3, obj.getImmatriculation());
			return statement.execute();
		}
	
	}

	@Override
	public Avion find(Integer id) throws SQLException {
		String requete = "select * from avion where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1,id);
			try(ResultSet result = statement.executeQuery();){
				result.first();
        		return new Avion(result.getString("immatriculation"),result.getInt("capacite"),result.getString("type"));
			}
		}
	}

}
