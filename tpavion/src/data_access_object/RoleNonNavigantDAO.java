package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.RoleNonNavigant;

public class RoleNonNavigantDAO extends DAO<RoleNonNavigant, String, RoleNonNavigant> {

	RoleNonNavigantDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(RoleNonNavigant obj) throws SQLException {
		String requete = "insert into RoleNonNavigant values (?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(RoleNonNavigant obj) throws SQLException {
		String requete = "delete from RoleNonNavigant where role=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			return statement.execute();
		}
	}

	@Override
	public boolean update(RoleNonNavigant obj) throws SQLException {
		/* modification impossible */
		return false;
	}

	@Override
	public RoleNonNavigant find(String id) throws SQLException {
		String requete = "select * from Role where role=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, id);
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
			        return new RoleNonNavigant(result.getString("Role"));
				return null;
			}
		}
	}
}
