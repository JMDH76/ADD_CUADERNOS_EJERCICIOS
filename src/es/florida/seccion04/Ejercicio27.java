/*27. Amplía el programa anterior para que implemente el código necesario para interrogar a la 
base de datos con una sentencia SQL. Implementa una sentencia que permita recuperar 
todo el contenido de una tabla de la base de datos*/

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
			ResultSet rs = stmt.executeQuery("SELECT * FROM zapatos"); //Objeto con el resultado de la consulta SQL

			comprobarRecuperarContenido(rs);

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
			System.out.println("Conexión realizada con éxito\n");
		else
			System.out.println("Conexion Fallida");
	}
	
	
	/*comprobarRecuperarContenido()
	 * ACTION:	comprueba si se ha accedido a los datos que solicita la senteencia SQL si devuelve true es que está
	 * apuntando a una linea y por tanto ha recibido datos.
	 * INPUT:	Recibe objeto ResultSet y comprueba que contiene datos
	 * OUTPUT:	Devuelve mensaje con el resultado de la comprobación*/
	public static void comprobarRecuperarContenido(ResultSet rs) throws SQLException {
		if (rs.next())
			System.out.println("Se ha recuperado el contenido de la tabla\n");
		else
			System.out.println("No se ha recuperado el contenido de la tabla\n");
	}
	
}
