package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.DepartPassager;

public class DepartPassagerDAO extends DAO<DepartPassager> {
	
	DepartPassagerDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(DepartPassager obj) throws SQLException {	    
		String requete ="insert into DepartPassager values (?,?,?,?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getNumPasseport());
			statement.setInt(2, obj.getId());
			statement.setDate(3, obj.getDateDepart());
			statement.setInt(4,obj.getNumPlace());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delete(DepartPassager obj) throws SQLException {
		String requete ="delete from DepartPassager where numPasseport=? and id=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getNumPasseport());
			statement.setInt(2, obj.getId());
			statement.setDate(3, obj.getDateDepart());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean update(DepartPassager obj) throws SQLException {
		String requete ="update DepartPassager set numPlace=? where numPasseport=? and id=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setInt(1, obj.getNumPlace());
			statement.setString(2, obj.getNumPasseport());
			statement.setInt(3, obj.getId());
			statement.setDate(4, obj.getDateDepart());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public DepartPassager find(DepartPassager obj) throws SQLException {
		String requete = "select * from DepartPassager where numPasseport=? and id=? and dateDepart=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getNumPasseport());
			statement.setInt(2, obj.getId());
			statement.setDate(3, obj.getDateDepart());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
					return new DepartPassager(result.getString("numPasseport"),result.getInt("id"),result.getDate("dateDepart"),result.getInt("numPlace"));
				return null;
			}
		}
	}
}
