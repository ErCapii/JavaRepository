package Ejercicio1ServicioPeliculas.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio1ServicioPeliculas.modelo.Pelicula;

public class PeliculasDao {

	public List<Pelicula> listaPeliculas(Connection conn) throws SQLException {
		String sql = "Select * from film";
		List<Pelicula> lista = new ArrayList<Pelicula>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula p = new Pelicula();
				p.setId(rs.getInt("film_id"));
				p.setNombre(rs.getString("title"));
				p.setLongitud(rs.getInt("length"));
				lista.add(p);
			}
		}
		return lista;
	}

}
