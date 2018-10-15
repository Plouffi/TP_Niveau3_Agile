package data_model;

public enum TypeRole {
	NAVIGANT ("navigant"),
	NONNAVIGANT ("nonnavigant");
	
	private String type="";
	private TypeRole(String type){
	    this.type = type;
	  }
	   
	public String getType(){
	    return type;
	}
	
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
