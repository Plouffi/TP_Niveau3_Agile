package data_model;

public class Role {

	private String role; 
	private TypeRole type;
	
	public Role(String role,TypeRole type)
	{
		this.role = role;
		this.type = type;
	}

	public TypeRole getType() {
		return type;
	}

	public void setType(TypeRole type) {
		this.type = type;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
