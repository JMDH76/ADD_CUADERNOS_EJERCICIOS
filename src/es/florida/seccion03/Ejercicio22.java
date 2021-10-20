package es.florida.seccion03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio22 {
	
	public static void main(String[] args) {

		Zapato zapato;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\zapateria.xml"));

			Element raiz = document.getDocumentElement();
			System.out.println("Contenido XML de " + raiz.getNodeName());

			NodeList nodelist = document.getElementsByTagName("zapato");
			int numeronodos = nodelist.getLength();
			System.out.println(
					"El nodo principal \"" + raiz.getNodeName() + "\" contiene " + numeronodos + " nodos u objetos.");

			ArrayList<Zapato> listazapatos = new ArrayList<Zapato>(); // Opcion con tamaño sin definir (ArrayList)

			for (int i = 0; i < nodelist.getLength(); i++) {

				Node node = nodelist.item(i);
				Element eElement = (Element) node;
				//Obtenemos y presentamos
				System.out.println("\n");
				String id = eElement.getAttribute("id");
				System.out.println("   ID zapato: " + id + "\n   ------------");

				String tipo = eElement.getElementsByTagName("tipo").item(0).getTextContent();
				System.out.println("	Tipo:	" + tipo);

				String marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
				System.out.println("	Marca:	" + marca);

				String modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
				System.out.println("	Modelo:	" + modelo);

				String color = eElement.getElementsByTagName("color").item(0).getTextContent();
				System.out.println("	Color:	" + color);

				String talla = eElement.getElementsByTagName("talla").item(0).getTextContent();
				System.out.println("	Talla:	" + talla);

				String precio = eElement.getElementsByTagName("precio").item(0).getTextContent();
				System.out.println("	Precio: " + precio);

				zapato = new Zapato (id, tipo, marca, modelo, color, talla, precio); // Creamos objeto "Zapato zapato"
				listazapatos.add(zapato); // Añadimos al ArrayList (guardado)
				System.out.print("\n	Objeto añadido a la lista:" + zapato.getToString()); //Mostramnos el objeto
			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}