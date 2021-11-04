/*31. Implementa un método que permita, dado un id de la tabla, borrar la entrada.*/

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

			PreparedStatement psBorrar = con.prepareStatement("DELETE FROM zapatos WHERE id = " + id);

			int resultadoBorrar = psBorrar.executeUpdate();

			System.out.println("\nReferencia borrada correctamente");

			teclado.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*METODO: filtroLinea(Connection con, int id)
	 * ACTION: 	crea una sentencia SQL en la que filtramos por la id proporcionada y
	 * crea un string con todos los datos de todas las columnas.
	 * INPUT:	recibe Objeto Connection y la id seleccionada
	 * OUTPUT:	devuelve un string montado con los datos de la linea filtrada */
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

	/*Metodo ComprobarConexion()
	 * Action: comprueba si se ha conectado con la BDD. Si la vble "con" es null es uqe no se ha conectado.
	 * INPUT:	recibe el objeto Connection con.
	 * OUTPUT:	Devuelve un mensaje con el resultado de l aconexion. */
	public static void comprobarConexion(Connection con) {
		if (!con.equals(null))
			System.out.println("Conecxión realizada con éxito\n");
		else
			System.err.println("Conexion Fallida");
	}

}
	