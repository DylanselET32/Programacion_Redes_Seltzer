package repasoPOO;

import repasoPOO.*; 


public class Detective extends Persona {
	protected int nPlaca;

	public int getnPlaca() {
		return nPlaca;
	}

	public void setnPlaca(int nPlaca) {
		this.nPlaca = nPlaca;
	}

	public Detective(String nombre, String apellido, int nDni, Foto foto, int nPlaca) {
		super(nombre, apellido, nDni, foto);
		// TODO Auto-generated constructor stub
		this.nPlaca = nPlaca;
	} 
	

}
