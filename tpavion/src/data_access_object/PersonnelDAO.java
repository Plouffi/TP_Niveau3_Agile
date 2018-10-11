package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Personnel;
import data_model.TypePossible;

public class PersonnelDAO extends DAO<Personnel, Integer, Personnel> {

	PersonnelDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Personnel obj) throws SQLException {		
		String requete ="insert into personnel (prenom,nom,adresse,noTelephone,role,motDePasse,type) values (?,?,?,?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getPrenom());
			statement.setString(2, obj.getNom());
			statement.setString(3, obj.getAdresse());
			statement.setLong(4, obj.getNoTelephone().longValue());
			statement.setString(5, obj.getRole());
			statement.setString(6, obj.getMotDePasse());
			statement.setString(7, obj.getType().getType());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(Personnel obj) throws SQLException {		
		String requete ="delete from personnel where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			return statement.execute();
		}
	}

	@Override
	public boolean update(Personnel obj) throws SQLException {	
		String requete ="update personnel set prenom=?,nom=?,adresse=?,noTelephone=?,role=?,motDePasse=?,type=? where id='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getPrenom());
			statement.setString(2, obj.getNom());
			statement.setString(3, obj.getAdresse());
			statement.setLong(4, obj.getNoTelephone().longValue());
			statement.setString(5, obj.getRole());
			statement.setString(6, obj.getMotDePasse());
			statement.setString(7, obj.getType().getType());
			statement.setInt(8, obj.getId());
			return statement.execute();
		}
	}

	@Override
	public Personnel find(Integer id) throws SQLException {
		String requete = "select * from personnel where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, id);
			try(ResultSet result = statement.executeQuery();){
				if(result.first()) {
					return new Personnel(result.getInt("id"),result.getString("Prenom"),result.getString("nom"),result.getString("adresse")
							,result.getBigDecimal("noTelephone").toBigInteger(),result.getString("motDePasse"),
							TypePossible.getTypePossible(result.getString("type")),result.getString("role"));
				}
				return null;
			}
		}
	}

	
}
