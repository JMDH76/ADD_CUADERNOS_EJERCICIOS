package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio31 {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // Librería externa de Java
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			comprobarConexion(con);

			
			Scanner teclado = new Scanner(System.in);
			System.out.print("Indique la 'id' del producto a borrar: ");
			int id = teclado.nextInt();
			

			System.out.print("\nReferencia --> ");
			System.out.print(filtroLinea(con, id));
			
			PreparedStatement psBorrar = con
					.prepareStatement("DELETE FROM zapatos WHERE id = " + id);
			
			int resultadoBorrar = psBorrar.executeUpdate();
			
			System.out.println("\nReferencia borrada correctamente");
			
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
		rs.close();
		stmt.close();
		return linea;
	}


	public static void comprobarConexion(Connection con) {
		if (!con.equals(null))
			System.out.println("Conecxión realizada con éxito\n");
		else
			System.err.println("Conexion Fallida");
	}

}
	