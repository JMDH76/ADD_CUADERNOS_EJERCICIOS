package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio32_01 {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			comprobarConexion(con);

			Scanner teclado = new Scanner(System.in);
			System.out.print("Indique la 'id' del Articulo a modificar: ");
			int id = teclado.nextInt();

			String ref = filtroLinea(con, id);
			System.out.println("\nReferencia " + id + " --> " + ref);

			String parametro = "";
			String texto = "";
			int opcion = 0;
			while (opcion > 6 || opcion < 1) {

				System.out.println("\nIndique el par�metro que desea modificar:");
				System.out.println("1. Tipo\n2. Marca\n3. Modelo\n4. Color\n5. Talla\n6. Precio");
				System.out.print("Indique un opcion: ");
				opcion = teclado.nextInt();
			}

			if (opcion == 1) {
				parametro = "tipo";
				texto = "Nuevo tipo: ";
			} else if (opcion == 2) {
				parametro = "marca";
				texto = "Nueva marca: ";
			} else if (opcion == 3) {
				parametro = "modelo";
				texto = "Nuevo modelo: ";
			} else if (opcion == 4) {
				parametro = "color";
				texto = "Nuevo color: ";
			} else if (opcion == 5) {
				parametro = "talla";
				texto = "Nueva talla: ";
			} else if (opcion == 6) {
				parametro = "precio";
				texto = "Nuevo precio: ";
			}

			System.out.print("\n" + texto);
			String dato = teclado.next();

			PreparedStatement psActualizar = con
					.prepareStatement("UPDATE zapatos SET " + parametro + " = ? WHERE id = " + id);
			psActualizar.setString(1, dato);


			String confirmacion = "n";
			System.out.print("Confirma que desea modificar el art�culo? (s/n) ");

			while (!confirmacion.equals("s")) {
				confirmacion = teclado.next();
				
				if (confirmacion.toLowerCase().equals("s")) {
					int resultadoActualizar = psActualizar.executeUpdate();
					System.out.print("\nReferencia actualizada correctamente: ");

				} else {
					System.out.print("\nNo se ha modificado el producto --> ");
					ref = "";
					break;
				}
			}

			System.out.print(ref + " --> " + filtroLinea(con, id));

			teclado.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static String filtroLinea(Connection con, int id) throws SQLException {

		String linea = "";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `zapatos` WHERE id = " + id);

		while (rs.next()) {
			linea = String.valueOf(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
					+ rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
		}
		rs.close();
		stmt.close();
		return linea;
	}

	public static void comprobarConexion(Connection con) {
		if (!con.equals(null))
			System.out.println("Conecxi�n realizada con �xito\n");
		else
			System.err.println("Conexion Fallida");
	}

}