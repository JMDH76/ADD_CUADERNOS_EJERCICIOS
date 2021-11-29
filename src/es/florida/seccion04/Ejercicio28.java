/*28. Para comprobar que efectivamente se han recuperado todos los datos, implementar el 
código para recorrer el resultado de la consulta y mostrar por pantalla las entradas de la 
tabla. Puedes utilizar concatenación de strings para que el formato de salida sea más 
comprensible.*/

package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio28 {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // Librería externa de Java
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			comprobarConexion(con);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM zapatos");

			// Leemos linea a linea y sacamos por pantalla en string el contenido de la consulta
			System.out.println("");
			while (rs.next()) {
				System.out.print(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + "\n");
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/*Metodo ComprobarConexion()
	 * Action: comprueba si se ha conectado con la BDD. Si la vble "con" es null es uqe no se ha conectado.
	 * INPUT:	recibe el objeto Connection con.
	 * OUTPUT:	Devuelve un mensaje con el resultado de l aconexion. */
	public static void comprobarConexion(Connection con) {
		if (!con.equals(null))
			System.out.println("Conexión realizada con éxito");
		else
			System.err.println("Conexion Fallida");
	}
	
}
