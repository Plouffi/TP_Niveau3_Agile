package systeme;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;

import data_access_object.*;
import data_model.Role;
import data_model.Personnel;

public class SystemeGestionUtilisateur {

    private Connection conn;
    private Personnel utilisateurConnecte = null;
    private List<String> typeUtilisateur;
    private DAOFactory factory;

    /**
     * Constructeur d'un Systeme de gestion utilisateur
     * @param
     */
    public SystemeGestionUtilisateur(Connection conn) {
        this.conn = conn;
        this.typeUtilisateur = new ArrayList<>();
        this.factory = new DAOFactory(conn);
    }

    /**
     * Méthode permettant la connexion
     * @param id
     * @param mdp
     * @return
     */
    public boolean connexion(int id, String mdp) {
        DAO<Personnel> personnelDAO = factory.createPersonnelDAO();
        try {
            utilisateurConnecte =((PersonnelDAO) personnelDAO).find(new Personnel(id));
            return (utilisateurConnecte != null && utilisateurConnecte.getMotDePasse().equals(mdp));
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return false;
    }

    /**
     * Méthode permettant la deconnexion
     */
    public void deconnexion() {
        utilisateurConnecte = null;
        typeUtilisateur.clear();
    }

    /**
     * Getter de l'utilisateur actuellement connect�
     * @return
     */
    public Personnel getUtilisateurConnecte() {
        return utilisateurConnecte;
    }

    /**
     * Méthode permettant l'ajout d'un membre du personnel
     * @param personnel
     * @return
     */
    public boolean ajouterUtilisateur(Personnel personnel) {
        DAO<Personnel> personnelDAO = factory.createPersonnelDAO();
        try {
            return personnelDAO.create(personnel);
        }
        catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return false;
    }

    /**
     * Méthode permettant l'encodage d'une chaine de caractères
     * @param message
     * @return
     */
    private String encoderMessage(String message) {
        byte[] byteChaine = null;
        MessageDigest md=null;
        try {
            byteChaine = message.getBytes("UTF-8");
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] hash = md.digest(byteChaine);
        return hash.toString();
    }

    /**
     * Méthode permettant l'ajout d'un rôle
     * @param role
     * @return
     */
    public boolean ajouterRole(Role role) {
        DAO<Role> roleDAO = factory.createRoleDAO();
        try {
               return roleDAO.create(role);
        }
        catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return false;	
    }

    /**
     * Méthode permettant la suppression d'un utilisateur
     * @param personnel
     * @return
     */
    public boolean supprimerUtilisateur(Personnel personnel) {
        DAO<Personnel> personnelDAO = factory.createPersonnelDAO();
        try {
            if(personnel.getId()==utilisateurConnecte.getId())
                throw new SQLException(" Vous ne pouvez pas vous supprimer vous-mêmes de la base de données.");
            return personnelDAO.delete(personnel);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return false;
    }

    /**
     * Méthode permettant de voir si un utilisateur existe dans la base de données
     * @param personnel
     * @return
     */
    public Personnel rechercherUtilisateur(Personnel personnel) {
        try {
            return factory.createPersonnelDAO().find(personnel);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return null;
    }

    /**
     * Méthode permettant la mise à jour d'un utilisateur
     * @param personnel
     * @return
     */
    public boolean majUtilisateur(Personnel personnel) {
        try {
            return factory.createPersonnelDAO().update(personnel);
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return false;
    }

    /**
     * Méthode retournant tous les rôles
     * @return
     */
    public List<Role> getRoles(){
        try {
            return ((RoleDAO) factory.createRoleDAO()).findRoles();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
            logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
        }
        return new ArrayList<>();
    }


    /**
     * M�thode retournant tous les membres du personnel
     * @return
     */
    public List<Personnel> getPersonnels(){
    try {
        return ((PersonnelDAO) factory.createPersonnelDAO()).findAll();
    } catch (SQLException e) {
        Logger logger = Logger.getLogger(SystemeGestionUtilisateur.class.getName());
        logger.log(Level.SEVERE, e.getSQLState()+" - "+e.getMessage());
    }
    return new ArrayList<>();
    }
}
