package dto;

import java.util.Objects;

public class stockDTO implements generalDTO{
	private int id;
	private String nombre;
	private String descripcion;
	private double precio_compra;
	private double precio_venta;
	private int cantidad;
	private boolean discontinuo;
	
	public stockDTO(int id, String nombre, String descripcion, double precio_compra, double precio_venta, int cantidad, boolean discontinuo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cantidad = cantidad;
		this.discontinuo = discontinuo;
	}
	public stockDTO(String nombre, String descripcion, double precio_compra, double precio_venta, int cantidad, boolean discontinuo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cantidad = cantidad;
		this.discontinuo = discontinuo;
	}
	public stockDTO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public boolean isDiscontinuo() {
		return discontinuo;
	}
	public void setDiscontinuo(boolean discontinuo) {
		this.discontinuo = discontinuo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcion, discontinuo, id, nombre, precio_compra, precio_venta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		stockDTO other = (stockDTO) obj;
		return cantidad == other.cantidad && Objects.equals(descripcion, other.descripcion)
				&& discontinuo == other.discontinuo && id == other.id && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio_compra) == Double.doubleToLongBits(other.precio_compra)
				&& Double.doubleToLongBits(precio_venta) == Double.doubleToLongBits(other.precio_venta);
	}
	
	@Override
	public String toString() {
		String str = "\n";
		str += "\nCodigo de producto: "+this.id;
		str += "\nNombre: "+this.nombre;
		str += "\nDescripcion: "+this.descripcion;
		str += "\nPrecio de compra: "+this.precio_compra;
		str += "\nPrecio de venta: "+this.precio_venta;
		str += "\nStock cantidad: "+this.cantidad;
		str += "\nEstado: ";
		if(this.discontinuo){
			str += "Descontinuado";
		}else {
			str += "En Utilizacion";
		}
		
		return str;
	}
	
	
	

}
