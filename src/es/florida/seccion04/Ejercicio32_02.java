package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio32_02 {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			comprobarConexion(con);

			Scanner teclado = new Scanner(System.in);
			System.out.print("Indique la 'id' del artículo que desea borrar: ");
			int id = teclado.nextInt();
		
			System.out.print("\nArtículo --> ");
			System.out.println(filtroLinea(con, id));
			
			PreparedStatement psBorrar = con
					.prepareStatement("DELETE FROM zapatos WHERE id = " + id);
			
		
			String confirmacion = "n";
			System.out.print("\nConfirma que desea eliminar este artículo? (s/n) ");

			while (!confirmacion.equals("s")) {
				confirmacion = teclado.next();
				
				if (confirmacion.toLowerCase().equals("s")) {
					int resultadoBorrar = psBorrar.executeUpdate();
					System.out.print("\nArticulo borrado correctamente.");

				} else {
					System.out.print("\nNo se ha borrado el articulo");
					break;
				}
			}
			
			teclado.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static String filtroLinea(Connection con, int id) throws SQLException {
		
		String linea="";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `zapatos` WHERE id = " + id);

		while (rs.next()) {
			linea = String.valueOf(rs.getString(1) + " " + rs.getString(2)
					+ " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6)
					+ " " + rs.getString(7));
		}
		return linea;
	}


	public static void comprobarConexion(Connection con) {
		if (!con.equals(null))
			System.out.println("Conecxión realizada con éxito\n");
		else
			System.err.println("Conexion Fallida");
	}

}
	