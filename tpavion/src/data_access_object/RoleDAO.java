package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_model.Role;
import data_model.TypeRole;

public class RoleDAO extends DAO<Role> {

	/**
	 * Constructeur appelant le constructeur de la super classe
	 * @param connexion
	 */
	RoleDAO(Connection connexion) {
		super(connexion);
	}

	/**
	 * Fonction permettant l'insertion d'un Role dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean create(Role obj) throws SQLException {
		String requete = "insert into Role values (?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			statement.setString(2, obj.getType().getType());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la suppression d'un Role existant dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean delete(Role obj) throws SQLException {
		String requete = "delete from Role where role=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			statement.setString(2, obj.getType().getType());
			/* retourne true si la requete s'est bien effectu� */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la mise � jour d'un Role existant dans la base de donn�es
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean update(Role obj) throws SQLException {
		/* modification impossible */
		return false;
	}

	/**
	 * Fonction permettant la r�cup�ration d'un Role existant dans la base de donn�es en utilisant le r�le et son type
	 * @param obj
	 * @return role
	 * @throws SQLException
	 */
	@Override
	public Role find(Role obj) throws SQLException {
		String requete = "select * from Role where role=? and type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getRole());
			statement.setString(2, obj.getType().getType());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
			        return new Role(result.getString("type"),result.getString("Role"));
				return null;
			}
		}
	}
	
	public List<Role> findRoles() throws SQLException {
		String requete = "select * from Role;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			try(ResultSet result = statement.executeQuery();){
				ArrayList<Role> roles = new ArrayList<>();
				while(result.next())
			        roles.add(new Role(result.getString("type"),result.getString("Role")));
				return roles;
			}
		}
	}
}
