package data_model;

import java.sql.Date;

public class RapportPilote {

		private int idPilote;
		private int idDepart;
		private Date dateDepart;
		private String rapport;
		
		public RapportPilote(int idPilote,int idDepart,Date dateDepart, String rapport){
			this.idPilote = idPilote;
			this.dateDepart = dateDepart;
			this.idDepart = idDepart;
			this.rapport = rapport;
		}

		public int getIdPilote() {
			return idPilote;
		}

		public void setIdPilote(int idPilote) {
			this.idPilote = idPilote;
		}

		public int getIdDepart() {
			return idDepart;
		}

		public void setIdDepart(int idDepart) {
			this.idDepart = idDepart;
		}

		public Date getDateDepart() {
			return dateDepart;
		}

		public void setDateDepart(Date dateDepart) {
			this.dateDepart = dateDepart;
		}

		public String getRapport() {
			return rapport;
		}

		public void setRapport(String rapport) {
			this.rapport = rapport;
		}

	
}
