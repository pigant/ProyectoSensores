package com.ignacio.proyectosensores.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class BD {

	private Connection c;
	private static boolean testing = false;

	public static void setTesting() throws SQLException {
		testing = true;
	}

	public BD() throws SinBaseDatosException {
		try {
			c = DriverManager.getConnection(
					"jdbc:postgresql://10.0.1.250/sensores",
					"postgres", "postgres");
			if (testing) {
				c.createStatement().execute("set search_path to test");
			}
		} catch (SQLException ex) {
			throw new SinBaseDatosException(ex);
		}
	}

	public boolean update(String consulta, Object... parametros)
			throws CodigoRepetidoException, RestriccionException {
		PreparedStatement ps = null;
		try {
			ps = c.prepareStatement(consulta);
			for (int i = 0; i < parametros.length; i++) {
				Object o = parametros[i];
				ps.setObject(i + 1, o);
			}
			int sa = ps.executeUpdate();
			return sa == 1;
		} catch (SQLException ex) {
			switch (ex.getSQLState()) {
				case "23505":
					throw new CodigoRepetidoException(ex);
				case "23503":
					throw new RestriccionException(ex);
			}

			Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	public Statement createStatement() throws SQLException {
		return c.createStatement();
	}

	public PreparedStatement createStatement(String consulta) throws SQLException {
		return c.prepareStatement(consulta);
	}

	public List<Object[]> select(
			String tabla,
			String condicion,
			String... columnas) {
		//
		try {
			StringBuilder sb = new StringBuilder("select ");
			for (String c : columnas) {
				sb.append(c).append(',');
			}
			sb.deleteCharAt(sb.length() - 1).
					append(" from ").
					append(tabla).append(" where ").
					append(condicion);
			ResultSet r = c.createStatement().executeQuery(sb.toString());
			List<Object[]> array = new ArrayList<>();
			while (r.next()) {
				Object[] o = new Object[columnas.length];
				for (int i = 0; i < columnas.length; i++) {
					o[i] = r.getObject(columnas[i]);
				}
				array.add(o);
			}
			r.close();
			return array;
		} catch (SQLException ex) {
			Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public void close() {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(BD.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	int lastId() throws SQLException {
		int id;
		ResultSet r;
		String consulta = "select lastval() as i";
		r = createStatement().executeQuery(consulta);
		r.next();
		id = r.getInt("i");
		r.close();
		return id;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalizando a bd");
		close();
		super.finalize(); //To change body of generated methods, choose Tools | Templates.
	}

}
