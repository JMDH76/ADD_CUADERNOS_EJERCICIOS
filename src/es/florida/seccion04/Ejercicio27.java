package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio27 {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			comprobarConexion(con);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM zapatos");
			
			comprobarRecuperarContenido(rs);

			rs.close();
			stmt.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static void comprobarConexion(Connection con) {
		if (!con.equals(null))
			System.out.println("Conecxión realizada con éxito\n");
		else
			System.out.println("Conexion Fallida");
	}
	
	
	public static void comprobarRecuperarContenido(ResultSet rs) throws SQLException {
		if (rs.next())
			System.out.println("Se ha recuperado el contenido de la tabla\n");
		else
			System.out.println("No se ha recuperado el contenido de la tabla\n");
	}
	
}
