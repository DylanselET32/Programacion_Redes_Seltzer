package principal;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.LinkedList;

import dao.daoFactory;
import dao.stockDAO;
import dto.DTOfactory;
import dto.stockDTO;
import utils.Leer;

public class main {
	public static PrintStream ps = new PrintStream(System.out);
	
		public static void main(String[] args) {
			
			
			//actualizo la base de datos local
			LinkedList<stockDTO> productosH2 = daoFactory.getInstance().getDAO("stock").getAllH2();
		    daoFactory.getInstance().getDAO("stock").setAll(productosH2);
		    menu();
		    
	}
		
		
	
		public static void menu() {
			
		    int eleccion = -1;
		    while (eleccion != 0) {
		    	ps.println("\n--------- MENU --------");
			    ps.println("1 > VER PRODUCTOS");
			    ps.println("2 > AGREGAR NUEVO PRODUCTO");
			    ps.println("3 > MODIFICAR STOCK");
			    ps.println("4 > DESCONTINUAR PRODUCTO");
			    ps.println("5 > ELIMINAR PRODUCTO");
			    ps.println("0 > SALIR");
			    eleccion = Leer.leerRInt("Opcion: ");
			    switch(eleccion) {
		        case 1:
		            verProductos();
		            break;
		        case 2:
		            agregarProducto();
		            break;
		        case 3:
		        	modificarProducto();
		        	break;
		        case 4:
		        	descontinuarProducto();
		        	break;
		        case 5:
		        	eliminarProducto();
		        	break;
		        case 0:
		        	
		        	//actualizo la base de datos global
					LinkedList<stockDTO> productosLocales = daoFactory.getInstance().getDAO("stock").getAll();
				    daoFactory.getInstance().getDAO("stock").setAllH2(productosLocales);
				    
		            ps.println("¡Hasta luego!");
		            break;
		        default:
		            ps.println("Opción no válida. Por favor, elige una opción válida.");
		            break;
			    }
		    }
		   
	
		    
		}

		public static void verProductos() {
		    ps.println("\n --------- VER PRODUCTOS --------");
		    LinkedList<stockDTO> productos = daoFactory.getInstance().getDAO("stock").getAll();
		    for(stockDTO p : productos) {
		    	ps.println(p.toString());
		    }
		}

		public static void agregarProducto() {
		    ps.println("\n --------- AGREGAR NUEVO PRODUCTO --------");
		   
		    String nombre = Leer.leerR("Nombre del producto: ");
		    String descripcion = Leer.leerR("Descripción: ");
		    double precioCompra = Leer.leerDouble("Precio de compra: ");
		    double precioVenta = Leer.leerDouble("Precio de venta: ");
		    int cantidad = Leer.leerInt("Cantidad: ");
		    boolean discontinuo = false;
		    
		    stockDTO d= new stockDTO(nombre, descripcion, precioCompra, precioVenta, cantidad, discontinuo); 
		    daoFactory.getInstance().getDAO("stock").add(d);
			ps.println("Se agrego " +d.getNombre()+" con exito!");


		}
		public static void modificarProducto() {
			ps.println("\n --------- MODIFICAR PRODUCTO --------");
			 LinkedList<stockDTO> productos = daoFactory.getInstance().getDAO("stock").getAll();
			    for(stockDTO p : productos) {
			    	ps.println(p.getId()+" - "+p.getNombre());
			    }
			int eleccionP = Leer.leerRInt("Elija el numero de producto a modificar:"); 
			
			stockDTO st = (stockDTO)daoFactory.getInstance().getDAO("stock").getById(eleccionP);

			
			ps.println("(Entre parentesis aparece los datos anterioreas, dejar vacio si desea conservarlos)");
			String nombre = Leer.leerR("Nombre del producto("+st.getNombre()+"): ");
			String descripcion = Leer.leerR("Descripción("+st.getDescripcion()+"): ");
			Double precioCompra = Leer.leerRDouble("Precio de compra("+st.getPrecio_compra()+"): ");
			Double precioVenta = Leer.leerRDouble("Precio de venta("+st.getPrecio_venta()+"): ");
			int cantidad = Leer.leerRInt("Cantidad("+st.getCantidad()+"):");
			
			if(nombre != null || nombre != "") st.setNombre(nombre);
			if(descripcion != null|| descripcion != "") st.setDescripcion(descripcion);
			if(precioCompra != null) st.setPrecio_compra(precioCompra);
			if(precioVenta != null) st.setPrecio_venta(precioVenta);
			st.setCantidad(cantidad);
			daoFactory.getInstance().getDAO("stock").update(st);
			ps.println("Se modifico " +st.getNombre()+" con exito!");
			
		}
		public static void descontinuarProducto() {
			ps.println("\n --------- DESCONTINUAR PRODUCTO --------");
			 LinkedList<stockDTO> productos = daoFactory.getInstance().getDAO("stock").getAll();
			    for(stockDTO p : productos) {
			    	ps.println(p.getId()+" - "+p.getNombre());
			    }
			int eleccionP = Leer.leerRInt("Elija el numero de producto a descontinuar:"); 
			
			
			stockDTO st = (stockDTO)daoFactory.getInstance().getDAO("stock").getById(eleccionP);
			st.setDiscontinuo(true);
			daoFactory.getInstance().getDAO("stock").update(st);
			ps.println("Se descontinuo " +st.getNombre()+" con exito!");
			
		}
		
		public static void eliminarProducto() {
			ps.println("\n --------- ELIMINAR PRODUCTO --------");
			 LinkedList<stockDTO> productos = daoFactory.getInstance().getDAO("stock").getAll();
			    for(stockDTO p : productos) {
			    	ps.println(p.getId()+" - "+p.getNombre());
			    }
			int eleccionP = Leer.leerRInt("Elija el numero de producto a Eliminar:"); 
			
			
			stockDTO st = (stockDTO)daoFactory.getInstance().getDAO("stock").getById(eleccionP);
			daoFactory.getInstance().getDAO("stock").delete(st);
			ps.println("Se elimino " +st.getNombre()+" con exito!");
			
		}

}
