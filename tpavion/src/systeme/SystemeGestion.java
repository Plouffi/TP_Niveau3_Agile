package systeme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import state.Contexte;
import state.EtatInitial;

public class SystemeGestion {

	SystemeGestionUtilisateur sgu;
	private final String user = "root";
	private final String pass = "";
	private final String dbClass = "com.mysql.cj.jdbc.Driver";
	private final String dbDriver = "jdbc:mysql://127.0.0.1:3306/tpavion?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection conn;
	
	public SystemeGestion(){   
		try {
			Class.forName(dbClass).newInstance();
			Connection conn = DriverManager.getConnection(dbDriver, user, pass);
			sgu = new SystemeGestionUtilisateur(conn); 
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void afficherInterface() {
		Contexte contexte = new Contexte();
		contexte.setElement(this);
		contexte.setState(new EtatInitial());
	}
	
	public SystemeGestionUtilisateur getSystemeGestionUtilisateur() {
		return sgu;
	}

}
