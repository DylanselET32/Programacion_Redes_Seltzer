package repasoPOO;

import repasoPOO.*; 


public class Mafioso extends Persona {
	protected Pistola pistola;

	public int getnPlaca() {
		return nPlaca;
	}

	public void setnPlaca(int nPlaca) {
		this.nPlaca = nPlaca;
	}

	public Mafioso(String nombre, String apellido, int nDni, Foto foto, int nPlaca, int nSerie,int balas) {
		super(nombre, apellido, nDni, foto);
		// TODO Auto-generated constructor stub
		pistola = new Pistola(nSerie, balas);
	} 
	

}
