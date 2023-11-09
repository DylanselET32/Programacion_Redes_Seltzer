package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.connectionFactory;
import dto.DTOfactory;
import dto.stockDTO;
import principal.connectionFactory;

public class stockDAO implements GeneralDAO<stockDTO>{
	
	
	final Logger LOG = Logger.getLogger(stockDTO.class.getName());


	@Override
	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA AGREGAR PRODUCTOS
	 * -----------------------------------------------------------------------------------
	*/
	public int add(stockDTO item) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {

			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO stock").append("(nombre, descripcion, precio_compra, precio_venta, cantidad, discontinuo)").append(" VALUES ");
			sql.append("(");
			sql.append("'").append(item.getNombre()).append("'").append(", ");
			sql.append("'").append(item.getDescripcion()).append("'").append(", ");
			sql.append(item.getPrecio_compra()).append(", ");
			sql.append(item.getPrecio_venta()).append(", ");
			sql.append(item.getCantidad()).append(", ");
			sql.append(item.isDiscontinuo()).append(");  ");

			
			
			conn = connectionFactory.getInstance().getConection("MySQL");
			ps = conn.prepareStatement(sql.toString());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(item.getId())).concat(" - TABLA: Stock"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return 0;
	}
	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA AGREGAR MUCHOS PRODUCTOS
	 * -----------------------------------------------------------------------------------
	*/
	public int add(LinkedList<stockDTO> lista) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {

			StringBuilder sql = new StringBuilder();
			for (stockDTO r : lista) {
				sql.append("INSERT INTO stock").append("(nombre, descripcion, precio_compra, precio_venta, cantidad, discontinuo)").append(" VALUES ");
				sql.append("(");
				sql.append("'").append(r.getNombre()).append("'").append(", ");
				sql.append("'").append(r.getDescripcion()).append("'").append(", ");
				sql.append(r.getPrecio_compra()).append(", ");
				sql.append(r.getPrecio_venta()).append(", ");
				sql.append(r.getCantidad()).append(", ");
				sql.append(r.isDiscontinuo()).append(");  ");
			}

			conn = connectionFactory.getInstance().getConection("MySQL");
			ps = conn.prepareStatement(sql.toString());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return 0;
	}

	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA ELIMINAR PRODUCTO
	 * -----------------------------------------------------------------------------------
	*/
	
	@Override
	public int delete(stockDTO item) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM stock ").append(" WHERE ").append(" id=? ");

			conn = connectionFactory.getInstance().getConection("MySQL");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, item.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(item.getId())).concat(" - TABLA: Stock"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}
	
	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA ACTUALIZAR PRODUCTO
	 * ----------------------------------------------------------------------------------
	*/
	
	public int update(stockDTO registro) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			String consulta = "UPDATE stock SET nombre=? , descripcion=? , precio_compra=?, precio_venta=?, cantidad=?, discontinuo=? WHERE id=?";
			conn = connectionFactory.getInstance().getConection("MySQL");
			ps = conn.prepareStatement(consulta);

			ps.setString(1, registro.getNombre());
			ps.setString(2, registro.getDescripcion());
			ps.setDouble(3, registro.getPrecio_compra());
			ps.setDouble(4, registro.getPrecio_venta());
			ps.setInt(5, registro.getCantidad());
			ps.setBoolean(6, registro.isDiscontinuo());
			ps.setInt(7, registro.getId());
			
			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(registro.getId())).concat(" - TABLA: Stock"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA OBTENER TODOS LOS PRODUCTOS
	 * ----------------------------------------------------------------------------------
	*/
	
	@Override
	public LinkedList<stockDTO> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		LinkedList<stockDTO> aux = new LinkedList<stockDTO>();

		String sql = "SELECT * FROM stock";

		try {
			conn = connectionFactory.getInstance().getConection("MySQL");
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				aux.add( (stockDTO)DTOfactory.getInstance().getDTO("stock", rs));
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		} finally {
			cerrarConexiones(rs, ps, conn);
		}

		return aux;
	}
	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA OBTENER TODOS LOS PRODUCTOS del H2 (base global)
	 * ----------------------------------------------------------------------------------
	*/
	
	@Override
	public LinkedList<stockDTO> getAllH2() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		LinkedList<stockDTO> aux = new LinkedList<stockDTO>();

		String sql = "SELECT * FROM stock";

		try {
			conn = connectionFactory.getInstance().getConection("H2");
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				aux.add( (stockDTO)DTOfactory.getInstance().getDTO("stock", rs));
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		} finally {
			cerrarConexiones(rs, ps, conn);
		}

		return aux;
	}
	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA SETEAR TODOS LOS PRODUCTOS 
	 * ----------------------------------------------------------------------------------
	*/
	
	@Override
	public int setAll(LinkedList<stockDTO> lista) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    String sql = "UPDATE stock SET nombre = ?, descripcion = ?, precio_compra = ?, precio_venta = ?, cantidad = ?, discontinuo = ? WHERE id = ?";

	    try {
	        conn = connectionFactory.getInstance().getConection("MySQL");
	        conn.setAutoCommit(false);

	        ps = conn.prepareStatement(sql);

	        for (stockDTO stock : lista) {
	            ps.setString(1, stock.getNombre());
	            ps.setString(2, stock.getDescripcion());
	            ps.setDouble(3, stock.getPrecio_compra());
	            ps.setDouble(4, stock.getPrecio_venta());
	            ps.setInt(5, stock.getCantidad());
	            ps.setBoolean(6, stock.isDiscontinuo());
	            ps.setInt(7, stock.getId());

	            ps.addBatch();
	        }

	        int[] resultados = ps.executeBatch();

	        conn.commit();

	        return resultados.length;
	    } catch (SQLException e) {
	        try {
	            if (conn != null) {
	                conn.rollback();
	            }
	        } catch (SQLException e2) {
	            LOG.log(Level.SEVERE, "Error al hacer rollback", e2);
	        }
	        LOG.log(Level.SEVERE, null, e);
	        return 0;
	    } finally {
	        try {
	            conn.setAutoCommit(true);
	        } catch (SQLException e) {
	            LOG.log(Level.SEVERE, "Error al restaurar autocommit", e);
	        }
	        cerrarConexiones(rs, ps, conn);
	    }
	}
	/*-----------------------------------------------------------------------------------
	 * 								METODO SETEAR OBTENER TODOS LOS PRODUCTOS del H2 (base global)
	 * ----------------------------------------------------------------------------------
	*/
	
	@Override
	public int setAllH2(LinkedList<stockDTO> lista) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    String sql = "UPDATE stock SET nombre = ?, descripcion = ?, precio_compra = ?, precio_venta = ?, cantidad = ?, discontinuo = ? WHERE id = ?";

	    try {
	        conn = connectionFactory.getInstance().getConection("H2");
	        conn.setAutoCommit(false);

	        ps = conn.prepareStatement(sql);

	        for (stockDTO stock : lista) {
	            ps.setString(1, stock.getNombre());
	            ps.setString(2, stock.getDescripcion());
	            ps.setDouble(3, stock.getPrecio_compra());
	            ps.setDouble(4, stock.getPrecio_venta());
	            ps.setInt(5, stock.getCantidad());
	            ps.setBoolean(6, stock.isDiscontinuo());
	            ps.setInt(7, stock.getId());

	            ps.addBatch();
	        }

	        int[] resultados = ps.executeBatch();

	        conn.commit();

	        return resultados.length;
	    } catch (SQLException e) {
	        try {
	            if (conn != null) {
	                conn.rollback();
	            }
	        } catch (SQLException e2) {
	            LOG.log(Level.SEVERE, "Error al hacer rollback", e2);
	        }
	        LOG.log(Level.SEVERE, null, e);
	        return 0;
	    } finally {
	        try {
	            conn.setAutoCommit(true);
	        } catch (SQLException e) {
	            LOG.log(Level.SEVERE, "Error al restaurar autocommit", e);
	        }
	        cerrarConexiones(rs, ps, conn);
	    }
	}

	/*-----------------------------------------------------------------------------------
	 * 								METODO PARA obtener PRODUCTO por id
	 * ----------------------------------------------------------------------------------
	*/
	
	@Override
	public stockDTO getById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM stock WHERE id=?";

		try {
			conn = connectionFactory.getInstance().getConection("MySQL");
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				return (stockDTO)DTOfactory.getInstance().getDTO("stock", rs);
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		} finally {
			cerrarConexiones(rs, ps, conn);
		}
		return null;
	}

	
	
	
	private void cerrarConexiones(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		}
	}

	
}
