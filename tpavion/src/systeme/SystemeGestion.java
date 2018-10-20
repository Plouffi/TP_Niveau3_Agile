package systeme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

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

	/**
	 * Constructeur pour un systemeGestion
	 */
	public SystemeGestion(){   
		try {
			conn = DriverManager.getConnection(dbDriver, user, pass);
			sgu = new SystemeGestionUtilisateur(conn); 
			sga = new SystemeGestionAvion(conn);
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		/* pile contenant tous nos �tats */
		etats = new Stack<>();
		/* on place le premier etat et on lance la m�thode afficherInterface */
		setState(new EtatInitial());
	}

	/**
	 * m�thode permettant l'affichage de l'interface
	 */
	public void afficherInterface() {
		etats.peek().goNext(this);
	}

	/**
	 * Getter d'un systemeGestionUtilisateur
	 * @return SystemeGestionUtilisateur
	 */
	public SystemeGestionUtilisateur getSystemeGestionUtilisateur() {
		return sgu;
	}

	/**
	 * Getter d'un systemeGestionAvion
	 * @return SystemeGestionAvion
	 */
	public SystemeGestionAvion getSystemeGestionAvion() {
		return sga;
	}

	/**
	 * Setter pour un �tat
	 * @param etat
	 */
	public void setState(Etat etat) {
		etats.push(etat);
		afficherInterface();
	}

	/**
	 * M�thode permettant le retour � un menu pr�c�dent (� un �tat pr�c�dent)
	 */
	public void retourMenuPrecedent() {
		etats.pop();
		afficherInterface();
	}

	/**
	 * M�thode permettant la deconnexion
	 */
	public void deconnexion() {
		sgu.deconnexion();
		etats.clear();
		etats.push(new EtatInitial());
		afficherInterface();
	}


}
