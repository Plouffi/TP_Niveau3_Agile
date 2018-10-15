package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Role;
import data_model.TypeRole;

public class RoleDAO extends DAO<Role> {

	RoleDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Role obj) throws SQLException {
		String requete = "insert into Role values (?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			statement.setString(2, obj.getType().getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delete(Role obj) throws SQLException {
		String requete = "delete from Role where role=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			statement.setString(2, obj.getType().getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean update(Role obj) throws SQLException {
		/* modification impossible */
		return false;
	}

	@Override
	public Role find(Role obj) throws SQLException {
		String requete = "select * from Role where role=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			statement.setString(2, obj.getType().getType());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
			        return new Role(result.getString("Role"),TypeRole.getTypePossible(result.getString("type")));
				return null;
			}
		}
	}
}
