package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_model.Depart;

public class DepartDAO extends DAO<Depart, Integer, List<Depart>> {

	DepartDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(Depart obj) throws SQLException {
	    String requete ="insert into depart values (?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			statement.setDate(2, obj.getDateDepart());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(Depart obj) throws SQLException {
	    String requete = "delete from depart where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getId());
			return statement.execute();
		}
	}

	@Override
	public boolean update(Depart obj) throws SQLException {
		/* on ne doit pas modifier les rows de cette table */
	    return false;
	}

	@Override
	public List<Depart> find(Integer id) throws SQLException {
		String requete = "select * from depart where id=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, id);
			try(ResultSet result = statement.executeQuery();){
				List<Depart>retour = new ArrayList<>();
				while (result.next()) {
					retour.add(new Depart(result.getInt("id"),result.getDate("dateDepart")));
				}
				return retour;
			}
		}
	}

}
