package data_access_object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.DepartAvion;

public class DepartAvionDAO extends DAO<DepartAvion> {

    /**
     * Constructeur appelant le constructeur de la super classe
     * @param connexion
     */
    DepartAvionDAO(Connection connexion) {
        super(connexion);
    }

    /**
     * Fonction permettant l'insertion d'un DepartAvion dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean create(DepartAvion obj) throws SQLException {
        String requete =
            "insert into DepartAvion values (?,?,?,?);";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getId());
            statement.setDate(2, obj.getDateDepart());
            statement.setString(3, obj.getImmatriculation());
            statement.setInt(4, obj.getQteCarburant());
            /* retourne true si la requete s'est bien effectué */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la suppression d'un DepartAvion existant dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean delete(DepartAvion obj) throws SQLException {	    
        String requete = "delete from DepartAvion where id=?, dateDepart=?, immatriculation=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getId());
            statement.setDate(2, obj.getDateDepart());
            statement.setString(3, obj.getImmatriculation());
            /* retourne true si la requete s'est bien effectué */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la mise à jour d'un DepartAvion existant dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean update(DepartAvion obj) throws SQLException {	    
        String requete = "update DepartAvion set qteCarburant=? where id=?, dateDepart=?, immatriculation=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getQteCarburant());
            statement.setInt(2, obj.getId());
            statement.setDate(3, obj.getDateDepart());
            statement.setString(4, obj.getImmatriculation());
            /* retourne true si la requete s'est bien effectué */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la récupération d'un DepartAvion existant dans la base de données en utilisant l'immatriculation
     * de l'avion concerné, l'identifiant et la date du départ concerné
     * @param obj
     * @return departavion
     * @throws SQLException
     */
    @Override
    public DepartAvion find(DepartAvion obj) throws SQLException {
        String requete = "select * from DepartAvion where id=?, dateDepart=?, immatriculation=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, (int)obj.getId());
            statement.setDate(2, (Date)obj.getDateDepart());
            statement.setString(3, (String)obj.getImmatriculation());
            try(ResultSet result = statement.executeQuery();){
                if(result.first())
                    return new DepartAvion(result.getInt("id"),result.getDate("dateDepart"),result.getString("immatriculation"),result.getInt("qteCarburant"));
                return null;
            }
        }
    }
	
}
