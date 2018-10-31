package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data_model.Depart;

public class DepartDAO extends DAO<Depart> {

    /**
     * Constructeur appelant le constructeur de la super classe
     * @param connexion
     */
    DepartDAO(Connection connexion) {
        super(connexion);
    }

    /**
     * Fonction permettant l'insertion d'un Depart dans la base de donn�es
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean create(Depart obj) throws SQLException {
        String requete ="insert into depart values (?,?);";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getId());
            statement.setDate(2, obj.getDateDepart());			
            /* retourne true si la requete s'est bien effectué */
            return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la suppression d'un Depart existant dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean delete(Depart obj) throws SQLException {
    String requete = "delete from depart where id=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
                statement.setInt(1, obj.getId());
                /* retourne true si la requete s'est bien effectu� */
                return statement.executeUpdate() > 0;
        }
    }

    /**
     * Fonction permettant la mise à jour d'un Depart existant dans la base de données
     * @param obj
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean update(Depart obj) throws SQLException {
        /* on ne doit pas modifier les rows de cette table */
        return false;
    }

    /**
     * Fonction permettant la récupération d'un Depart existant dans la base de données en utilisant son identifiant
     * @param obj
     * @return depart
     * @throws SQLException
     */
    @Override
    public Depart find(Depart obj) throws SQLException {
        String requete = "select * from depart where id=?;";
        try(PreparedStatement statement = super.connexion.prepareStatement(requete);){
            statement.setInt(1, obj.getId());
            try(ResultSet result = statement.executeQuery();){
                if(result.first()) {
                        return new Depart(result.getInt("id"),result.getDate("dateDepart"));
                }
                return null;
            }
        }
    }
}
