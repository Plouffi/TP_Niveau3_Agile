package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.DepartPassager;

public class DepartPassagerDAO extends DAO<DepartPassager, Integer[],DepartPassager> {
	
	DepartPassagerDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(DepartPassager obj) throws SQLException {	    
		String requete ="insert into DepartPassager values (?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getNumPasseport());
			statement.setInt(2, obj.getId());
			statement.setDate(3, obj.getDateDepart());
			statement.setInt(4,obj.getNumPlace());
			return statement.execute();
		}
	}

	@Override
	public boolean delete(DepartPassager obj) throws SQLException {
		String requete ="\"delete from DepartPassager where numPasseport=? and id=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getNumPasseport());
			statement.setInt(2, obj.getId());
			statement.setDate(3, obj.getDateDepart());
			return statement.execute();
		}
	}

	@Override
	public boolean update(DepartPassager obj) throws SQLException {
		String requete ="update DepartPassager set numPlace=? where numPasseport=? and id=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getNumPlace());
			statement.setInt(2, obj.getNumPasseport());
			statement.setInt(3, obj.getId());
			statement.setDate(4, obj.getDateDepart());
			return statement.execute();
		}
	}

	@Override
	public DepartPassager find(Integer[] id) throws SQLException {
		String requete = "select * from DepartPassager where numPasseport=? and id=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, id[0]);
			statement.setInt(2, id[1]);
			statement.setInt(3, id[2]);
			try(ResultSet result = statement.executeQuery();){
				result.first();
	        	return new DepartPassager(result.getInt("numPasseport"),result.getInt("id"),result.getDate("dateDepart"),result.getInt("numPlace"));
			}
		}
	}
}
