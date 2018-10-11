package data_model;

public enum TypePossible {
	NAVIGANT ("navigant"),
	NONNAVIGANT ("nonnavigant");
	
	private String type="";
	private TypePossible(String type){
	    this.type = type;
	  }
	   
	public String getType(){
	    return type;
	}
	
	public static TypePossible getTypePossible(String typePersonnel) {
		switch(typePersonnel) {
			case "navigant":
				return TypePossible.NAVIGANT;
			case "nonnavigant":
				return TypePossible.NONNAVIGANT;
			default:
				return null;
		}
	}
}
