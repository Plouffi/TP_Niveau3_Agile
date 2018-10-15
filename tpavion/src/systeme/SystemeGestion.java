package systeme;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

import data_model.Personnel;
import state.Etat;
import state.EtatInitial;

public class SystemeGestion {

	SystemeGestionUtilisateur sgu;
	SystemeGestionAvion sga;
	private static final String user = "root";
	private static final String pass = "";
	private static final String dbClass = "com.mysql.cj.jdbc.Driver";
	private static final String dbDriver = "jdbc:mysql://127.0.0.1:3306/tpavion?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection conn = null;
	private Stack<Etat> etats;
	
	public SystemeGestion(){   
		try {
			Class.forName(dbClass).newInstance();
			conn = DriverManager.getConnection(dbDriver, user, pass);
			sgu = new SystemeGestionUtilisateur(conn); 
			sga = new SystemeGestionAvion(conn);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* pile contenant tous nos états */
		etats = new Stack<>();
		/* on place le premier etat et on lance la méthode afficherInterface */ 
		etats.push(new EtatInitial());
		afficherInterface();
	}
	
	public void afficherInterface() {
		etats.peek().goNext(this);
	}

	public SystemeGestionUtilisateur getSystemeGestionUtilisateur() {
		return sgu;
	}
	
	public SystemeGestionAvion getSystemeGestionAvion() {
		return sga;
	}

	public void setState(Etat etat) {
		etats.push(etat);
		afficherInterface();
	}
	
	public void retourMenuPrecedent() {
		etats.pop();
		afficherInterface();
	}

	public void deconnexion() {
		sgu.deconnexion();
		etats.clear();
		etats.push(new EtatInitial());
		afficherInterface();
	}

	public boolean connexion(int id, String password) {
		return sgu.connexion(id, password);
	}

}
