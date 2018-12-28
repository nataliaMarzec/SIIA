package ar.sarm.siia.modelo;

import javax.persistence.Entity;

@Entity
public class Cliente extends Persistible{
	private static final long serialVersionUID = 1L;
	
	private String fullName;
	
	public Cliente(){}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

}
