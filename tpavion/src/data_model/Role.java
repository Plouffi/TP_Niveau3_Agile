package data_model;

public class Role {

	private String role; 
	private TypeRole type;
	
	public Role(String type,String role)
	{
		this.role = role;
		this.type = TypeRole.getTypePossible(type);
	}

	public TypeRole getType() {
		return type;
	}

	public void setType(String type) {
		this.type = TypeRole.getTypePossible(type);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
