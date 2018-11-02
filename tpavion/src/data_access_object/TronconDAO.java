package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data_model.Troncon;

public class TronconDAO extends DAO<Troncon> {

    /**
     * Constructeur appelant le constructeur de la super classe
     * @param connexion
     */
    TronconDAO(Connection connexion) {
        super(connexion);
    }

    /**
     * Fonction permettant l'insertion d'un Troncon dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean create(Troncon obj) throws SQLException {
        String requete = "insert into Troncon values (?,?,?);";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setString(1, obj.getVilleDepart());
            statement.setString(2, obj.getVilleArrivee());
            statement.setInt(3, obj.getDistance());
            /* retourne true si la requete s'est bien effectuée */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la suppression d'un Troncon existant dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean delete(Troncon obj) throws SQLException {
        String requete = "delete from Troncon where id=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getId());
            /* retourne true si la requete s'est bien effectuée */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la mise à jour d'un Troncon existant dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean update(Troncon obj) throws SQLException {
        String requete = "update Troncon set villeDepart=?, villeArrivee=?, distance=? where id=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setString(1, obj.getVilleDepart());
            statement.setString(2, obj.getVilleArrivee());
            statement.setInt(3, obj.getDistance());
            statement.setInt(4, obj.getId());
            /* retourne true si la requete s'est bien effectuée */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la récupération d'un Troncon existant dans la base de données en utilisant son identifiant
     * @param obj
     * @return troncon
     * @throws SQLException
     */
    @Override
    public Troncon find(Troncon obj) throws SQLException {
        String requete = "select * from Troncon where id=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getId());
            try(ResultSet result = statement.executeQuery();){
                if(result.first())
                    return new Troncon(result.getInt("id"),result.getString("villeDepart"),result.getString("villeArrivee"),result.getInt("distance"));
                return null;
            }
        }
    }
}
