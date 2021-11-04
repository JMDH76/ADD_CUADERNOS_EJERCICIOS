/*26. Realiza un programa que importe la librería necesaria para poder realizar una conexión a 
una base de datos MySQL, realice la conexión a la base de datos anterior y muestre un 
mensaje si se ha hecho o no con éxito.*/

package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio26 {

	public static void main(String[] args) {

		try {

			// Librería externa mysql-conector parajava
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Nos conectamos a la BDD a través de localhost. "root" es el usuario por defecto y "" la contraseña va vacia
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			// Comprueba si la conexion se ha realizado con exito
			if (!con.equals(null))
				System.out.println("Conecxión realizada con éxito");
			else
				System.out.println("Conexion Fallida");

			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
