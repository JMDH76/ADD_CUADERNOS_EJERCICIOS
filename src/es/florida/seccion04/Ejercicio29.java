package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //Librería externa de Java
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			comprobarConexion(con);
			
			Scanner teclado = new Scanner (System.in);
			System.out.println("Inserte un nuevo artículo:");
			
			System.out.print("Tipo: ");		String tipo = teclado.next();
			System.out.print("Marca: ");	String marca = teclado.next();
			System.out.print("Modelo: ");	String modelo = teclado.next();
			System.out.print("Color: ");	String color = teclado.next();
			System.out.print("Talla: ");	String talla = teclado.next();
			System.out.print("Precio: ");	String precio = teclado.next();
			
			PreparedStatement psInsertar = con.prepareStatement(
					"INSERT INTO zapatos(tipo, marca, modelo, color, talla, precio) VALUES (?,?,?,?,?,?)");
			//No ponemos id porque es autoincrementado
			psInsertar.setString(1, tipo);
			psInsertar.setString(2, marca);
			psInsertar.setString(3, modelo);
			psInsertar.setString(4, color);
			psInsertar.setString(5, talla);
			psInsertar.setString(6, precio);
			int resultadoInsertar = psInsertar.executeUpdate();
			

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `zapatos`");

			System.out.println("");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) );
			}
			teclado.close();
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
			System.err.println("Conexion Fallida");
	}

}