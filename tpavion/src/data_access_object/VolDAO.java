package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Vol;

public class VolDAO extends DAO<Vol, Integer,Vol> {

	VolDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Vol obj) throws SQLException {
		String requete = "insert into Vol values ('?');";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getFrequence());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(Vol obj) throws SQLException {
		String requete = "delete from Vol where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			return statement.execute();
		}
	}

	@Override
	public boolean update(Vol obj) throws SQLException {
		String requete = "update Vol set frequence='?' where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getFrequence());
			statement.setInt(2, obj.getId());
			return statement.execute();
		}
	}

	@Override
	public Vol find(Integer id) throws SQLException {
		String requete ="select * from Vol where id='?'";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, id);
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
		        	return new Vol(result.getInt("id"),result.getInt("frequence"));
				return null;
			}
		}
	}

}
