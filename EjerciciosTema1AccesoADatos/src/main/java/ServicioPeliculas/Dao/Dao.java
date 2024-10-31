package ServicioPeliculas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ServicioPeliculas.Peliculas.Pelicula;

public class Dao {

	public List<Pelicula> buscar(Connection conn) throws SQLException {
		List<Pelicula> lista = new ArrayList<Pelicula>();
		String sql = "Select * from film";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pelicula pelis = new Pelicula();
				pelis.setId(rs.getInt("file_id"));
				pelis.setTitulo(rs.getString("title"));
				pelis.setLongitud(rs.getInt("lenght"));
				lista.add(pelis);
			}
		}
		return lista;
	}
}
