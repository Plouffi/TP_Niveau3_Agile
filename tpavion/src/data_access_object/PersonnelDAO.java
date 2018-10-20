package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_model.Role;
import data_model.Personnel;

public class PersonnelDAO extends DAO<Personnel> {

	/**
	 * Constructeur appelant le constructeur de la super classe
	 * @param connexion
	 */
	PersonnelDAO(Connection connexion) {
		super(connexion);
	}

	/**
	 * Fonction permettant l'insertion d'un Personnel dans la base de données
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean create(Personnel obj) throws SQLException {
		if(new RoleDAO(connexion).find(obj.getRole()) == null)
			throw new SQLException(" -- Erreur -- Le rôle n'existe pas.");
		String requete ="insert into personnel (prenom,nom,adresse,noTelephone,role,motDePasse,type) values (?,?,?,?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getPrenom());
			statement.setString(2, obj.getNom());
			statement.setString(3, obj.getAdresse());
			statement.setLong(4, obj.getNoTelephone().longValue());
			statement.setString(5, obj.getRole().getRole());
			statement.setString(6, obj.getMotDePasse());
			statement.setString(7, obj.getRole().getType().getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la suppression d'un Personnel existant dans la base de données
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean delete(Personnel obj) throws SQLException {
		String requete ="delete from personnel where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la mise à jour d'un Personnel existant dans la base de données
	 * @param obj
	 * @return boolean
	 * @throws SQLException
	 */
	@Override
	public boolean update(Personnel obj) throws SQLException {
		if(new RoleDAO(connexion).find(obj.getRole()) == null)
			throw new SQLException(" -- Erreur -- Le rôle n'existe pas.");
		String requete ="update personnel set prenom=?,nom=?,adresse=?,noTelephone=?,role=?,motDePasse=?,type=? where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getPrenom());
			statement.setString(2, obj.getNom());
			statement.setString(3, obj.getAdresse());
			statement.setLong(4, obj.getNoTelephone().longValue());
			statement.setString(5, obj.getRole().getRole());
			statement.setString(6, obj.getMotDePasse());
			statement.setString(7, obj.getRole().getType().getType());
			statement.setInt(8, obj.getId());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	/**
	 * Fonction permettant la récupération d'un Personnel existant dans la base de données en utilisant son identifiant
	 * @param obj
	 * @return depart
	 * @throws SQLException
	 */
	@Override
	public Personnel find(Personnel obj) throws SQLException {
		String requete = "select * from personnel where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			try(ResultSet result = statement.executeQuery();){
				if(result.first()) {
					return new Personnel(result.getInt("id"),result.getString("Prenom"),result.getString("nom"),result.getString("adresse")
							,result.getBigDecimal("noTelephone").toBigInteger(),result.getString("motDePasse"),
							new Role(result.getString("type"),result.getString("role")));
				}
				return null;
			}
		}
	}

	public List<Personnel> findAll() throws SQLException {
		String requete = "select * from personnel";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			try(ResultSet result = statement.executeQuery();){
				ArrayList<Personnel> retour = new ArrayList<>();
				while (result.next()){
					retour.add(new Personnel(result.getInt("id"),result.getString("Prenom"),result.getString("nom"),result.getString("adresse")
							,result.getBigDecimal("noTelephone").toBigInteger(),result.getString("motDePasse"),
							new Role(result.getString("type"),result.getString("role"))));
				}
				return retour;
			}
		}
	}
}
