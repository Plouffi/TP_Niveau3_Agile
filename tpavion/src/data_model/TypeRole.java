package data_model;

public enum TypeRole {
	NAVIGANT ("Navigant"),
	NONNAVIGANT ("NonNavigant");
	
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
			case "Navigant":
				return TypeRole.NAVIGANT;
			case "NonNavigant":
				return TypeRole.NONNAVIGANT;
			default:
				return null;
		}
	}
}
