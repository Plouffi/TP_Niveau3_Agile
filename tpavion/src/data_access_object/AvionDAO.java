package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data_model.Avion;
import data_model.TypeAvion;

public class AvionDAO extends DAO<Avion> {

	AvionDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Avion obj) throws SQLException {
	    String requete =
	        "insert into avion (immatriculation,capacite,type)" +
	        "values (?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getImmatriculation());
			statement.setInt(2, obj.getCapacite());
			statement.setString(3, obj.getType());
			/* retourne true si l'insert s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delete(Avion obj) throws SQLException {
	    String requete =
	        "delete from avion where immatriculation=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getImmatriculation());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean update(Avion obj) throws SQLException {
	    String requete =
	    		"update avion set type=?, capacite=? where immatriculation=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getType());
			statement.setInt(2, obj.getCapacite());
			statement.setString(3, obj.getImmatriculation());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	
	}

	@Override
	public Avion find(Avion obj) throws SQLException {
		String requete = "select * from avion where immatriculation=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1,obj.getImmatriculation());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
						return new Avion(result.getString("immatriculation"),result.getInt("capacite"),result.getString("type"));
				return null;
			}
		}
	}
	
	public boolean findType(TypeAvion typeAvion) throws SQLException {
		String requete = "select * from avion where type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1,typeAvion.getType());
			try(ResultSet result = statement.executeQuery();){
				return result.first();
			}
		}
	}

}
