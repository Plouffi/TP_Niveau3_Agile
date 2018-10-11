package data_access_object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.RapportPilote;

public class RapportPiloteDAO extends DAO<RapportPilote, Object[], RapportPilote> {

	RapportPiloteDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(RapportPilote obj) throws SQLException {
		String requete ="insert into RapportPilote values (?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getIdPilote());
			statement.setInt(2, obj.getIdDepart());
			statement.setDate(3, obj.getDateDepart());
			statement.setString(4, obj.getRapport());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(RapportPilote obj) throws SQLException {
		String requete ="delete from RapportPilote values where idPilote=? and idDepart=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getIdPilote());
			statement.setInt(2, obj.getIdDepart());
			statement.setDate(3, obj.getDateDepart());
			return statement.execute();
		}
	}

	@Override
	public boolean update(RapportPilote obj) throws SQLException {
		String requete = "update RapportPilote set rapport=? where idPilote=? and idDepart=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRapport());
			statement.setInt(2, obj.getIdPilote());
			statement.setInt(3, obj.getIdDepart());
			statement.setDate(4, obj.getDateDepart());
			return statement.execute();
		}
	}

	@Override
	public RapportPilote find(Object[] id) throws SQLException {
		String requete = "select * from RapportPilote where idPilote=? and idDepart=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, (int)id[0]);
			statement.setInt(2, (int)id[1]);
			statement.setDate(3, (Date)id[2]);
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
		        	return new RapportPilote(result.getInt("idPilote"),result.getInt("idDepart"),result.getDate("dateDepart"),result.getString("rapport"));
				return null;
			}
		}
	}

}
