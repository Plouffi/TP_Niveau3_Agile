package data_access_object;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data_model.Passager;

public class PassagerDAO extends DAO<Passager, Integer, Passager> {

	PassagerDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Passager obj) throws SQLException {
		String requete ="insert into passager values (?,?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getNumPasseport());
			statement.setString(2, obj.getPrenom());
			statement.setString(3, obj.getNom());
			statement.setString(4, obj.getAdresse());
			statement.setLong(5, obj.getNoTelephone().longValue());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(Passager obj) throws SQLException {		
		String requete ="delete from passager where numPasseport='?';";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getNumPasseport());
			return statement.execute();
		}
	}

	@Override
	public boolean update(Passager obj) throws SQLException {
		String requete ="update passager set prenom=?, nom=?, adresse=?, noTelephone=? where numPasseport=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getPrenom());
			statement.setString(2, obj.getNom());
			statement.setString(3, obj.getAdresse());
			statement.setLong(4, obj.getNoTelephone().longValue());
			statement.setInt(5,obj.getNumPasseport());
			return statement.execute();
		}
	}

	@Override
	public Passager find(Integer id) throws SQLException {
		String requete ="select * from passager where numPasseport=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, id);
			try(ResultSet result = statement.executeQuery();){
				result.first();
				return new Passager(result.getInt("numPasseport"),result.getString("prenom"),result.getString("nom"),result.getString("adresse"),result.getBigDecimal("noTelephone").toBigInteger());
			}
		}
	}

}
