package data_model;

public class Role {

	private String role; 
	private TypeRole type;

	/**
	 * Constructeur pour un r�le
	 * @param type
	 * @param role
	 */
	public Role(String type,String role)
	{
		this.role = role;
		this.type = TypeRole.getTypePossible(type);
	}

	/**
	 * Getter d'un type de r�le
	 * @return TypeRole
	 */
	public TypeRole getType() {
		return type;
	}

	/**
	 * Setter du type de r�le
	 * @param type
	 */
	public void setType(String type) {
		this.type = TypeRole.getTypePossible(type);
	}

	/**
	 * Getter du r�le
	 * @return String
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Setter du r�le
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	
}
