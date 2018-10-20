package data_model;

public enum TypeRole {
	NAVIGANT ("navigant"),
	NONNAVIGANT ("nonnavigant");
	
	private String type="";
	private TypeRole(String type){
	    this.type = type;
	  }

	/**
	 * Getter du type
	 * @return String
	 */
	public String getType(){
	    return type;
	}

	/**
	 * M�thode statique permettant de cr�er un type de r�le
	 * @param typePersonnel
	 * @return
	 */
	public static TypeRole getTypePossible(String typePersonnel) {
		switch(typePersonnel) {
			case "navigant":
				return TypeRole.NAVIGANT;
			case "nonnavigant":
				return TypeRole.NONNAVIGANT;
			default:
				return null;
		}
	}
}
