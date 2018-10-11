package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.RoleNavigant;

public class RoleNavigantDAO extends DAO<RoleNavigant, String, RoleNavigant> {

	RoleNavigantDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(RoleNavigant obj) throws SQLException {
		String requete = "insert into RoleNavigant values (?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(RoleNavigant obj) throws SQLException {
		String requete = "delete from RoleNavigant where role=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			return statement.execute();
		}
	}

	@Override
	public boolean update(RoleNavigant obj) throws SQLException {
		/* modification impossible */
		return false;
	}

	@Override
	public RoleNavigant find(String id) throws SQLException {
		String requete = "select * from Role where role=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, id);
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
			        return new RoleNavigant(result.getString("Role"));
				return null;
			}
		}
	}
}
