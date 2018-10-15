package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.TypeAvion;

public class TypeAvionDAO extends DAO<TypeAvion> {

	TypeAvionDAO(Connection connexion) {
		super(connexion);
	}

	@Override
	public boolean create(TypeAvion obj) throws SQLException {
		String requete = "insert into TypeAvion values (?);";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean delete(TypeAvion obj) throws SQLException {
		String requete = "delete from TypeAvion where type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getType());
			/* retourne true si la requete s'est bien effectué */
			return statement.executeUpdate() > 0;
		}
	}

	@Override
	public boolean update(TypeAvion obj) throws SQLException {
		return false;
	}

	@Override
	public TypeAvion find(TypeAvion obj) throws SQLException {
		String requete = "select * from typeAvion where type=?;";
		try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
			statement.setString(1, obj.getType());
			try(ResultSet result = statement.executeQuery();){
				if(result.first())
		        	return new TypeAvion(result.getString("type"));
				return null;
			}
		}
	}

}
