/*26. Realiza un programa que importe la librer�a necesaria para poder realizar una conexi�n a 
una base de datos MySQL, realice la conexi�n a la base de datos anterior y muestre un 
mensaje si se ha hecho o no con �xito.*/

package es.florida.seccion04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio26 {

	public static void main(String[] args) {

		try {

			// Librer�a externa mysql-conector parajava
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Nos conectamos a la BDD a trav�s de localhost. "root" es el usuario por defecto y "" la contrase�a va vacia
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zapateria", "root", "");

			// Comprueba si la conexion se ha realizado con exito
			if (!con.equals(null))
				System.out.println("Conexi�n realizada con �xito");
			else
				System.out.println("Conexion Fallida");

			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
