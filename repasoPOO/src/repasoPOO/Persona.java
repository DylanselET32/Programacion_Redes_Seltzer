package repasoPOO;
import repasoPOO.Dni;
import repasoPOO.Perfil;
import repasoPOO.Dni;


public class Persona {
	protected Dni dni;
	protected Perfil perfil;
	protected Antecedente antecedente;

	public Persona(String nombre, String apellido, int nDni, Foto foto) {
		this.dni = new Dni(nombre, apellido, nDni, foto);
	}

	public Dni getDni() {
		return dni;
	}

	public void setDni(Dni dni) {
		this.dni = dni;
	}
	
	
}

