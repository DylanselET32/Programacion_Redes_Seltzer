package repasoPOO;

import repasoPOO.Foto;

public class Dni {
protected String nombre;
protected String apellido;
protected int nDni;
protected Foto foto;
 
public Dni(String nombre, String apellido, int nDni, Foto foto) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.nDni = nDni;
	this.foto = foto;
	
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getnDni() {
	return nDni;
}

public void setnDni(int nDni) {
	this.nDni = nDni;
}

public Foto getFoto() {
	return foto;
}

public void setFoto(Foto foto) {
	this.foto = foto;
}
 
 
}
