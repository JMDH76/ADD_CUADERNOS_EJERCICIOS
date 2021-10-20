package es.florida.seccion03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio24 {

	public static void main(String[] args) {

		int ultimoId = 0;
		Zapato zapato;
		ArrayList<Zapato> listazapatos = new ArrayList<Zapato>(); // Opcion con tamaño sin definir (ArrayList)

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

			for (int i = 0; i < nodelist.getLength(); i++) {

				Node node = nodelist.item(i);
				Element eElement = (Element) node;
				// Obtenemos y presentamos
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

				zapato = new Zapato(id, tipo, marca, modelo, color, talla, precio); // Creamos objeto "Zapato zapato"
				listazapatos.add(zapato); // Añadimos al ArrayList (guardado)
				ultimoId = Integer.parseInt(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\n¿Desea añadir un zapato? (s/n) ");
			String respuesta = br.readLine().toLowerCase();

			if (respuesta.equals("s")) { //Si la respuesta es "no" salta este proceso y guarda directamente
				
				while (respuesta.equals("s")) {
					System.out.print("\nTipo:	");
					String tipo = br.readLine();
					System.out.print("Marca:	");
					String marca = br.readLine();
					System.out.print("Modelo:	");
					String modelo = br.readLine();
					System.out.print("Color:	");
					String color = br.readLine();
					System.out.print("Talla:	");
					String talla = br.readLine();
					System.out.print("Precio:	");
					String precio = br.readLine() + "€";
					ultimoId++;

					zapato = new Zapato(Integer.toString(ultimoId), tipo, marca, modelo, color, talla, precio);
					listazapatos.add(zapato);
					System.out.println("\nNuevo item guardado en la lista: " + zapato.getToString());
					System.out.print("\n¿Desea añadir un zapato? (s/n) ");
					respuesta = br.readLine().toLowerCase();
				}
				br.close();
				System.out.println("\nListado actualizado:\n-------------------");
				for (Zapato zap : listazapatos) {
					System.out.println(zap.getToString());
				}
			}
			writeXmlFile(listazapatos); // Crea la estructura del XML y la escribe en un fichero

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void writeXmlFile(ArrayList<Zapato> listazapatos) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.newDocument();

			Element raiz = document.createElement("zapateria");
			document.appendChild(raiz);

			for (Zapato zap : listazapatos) {

				Element zapato = document.createElement("zapato");
				String id = String.valueOf(zap.getId());
				zapato.setAttribute("id", id);
				raiz.appendChild(zapato);

				Element tipo = document.createElement("tipo");
				tipo.appendChild(document.createTextNode(String.valueOf(zap.getTipo())));
				zapato.appendChild(tipo);

				Element marca = document.createElement("marca");
				marca.appendChild(document.createTextNode(String.valueOf(zap.getMarca())));
				zapato.appendChild(marca);

				Element modelo = document.createElement("modelo");
				modelo.appendChild(document.createTextNode(String.valueOf(zap.getModelo())));
				zapato.appendChild(modelo);

				Element color = document.createElement("color");
				color.appendChild(document.createTextNode(String.valueOf(zap.getColor())));
				zapato.appendChild(color);

				Element talla = document.createElement("talla");
				talla.appendChild(document.createTextNode(String.valueOf(zap.getTalla())));
				zapato.appendChild(talla);

				Element precio = document.createElement("precio"); // crea el elemento "etiqueta"
				precio.appendChild(document.createTextNode(String.valueOf(zap.getPrecio()))); // Añade el dato al elemento
				zapato.appendChild(precio); // crea la etiqueta como hija de raiz

			}
			// Guardar el documento y serializar
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer aTransformer = tf.newTransformer();

			aTransformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1252"); //"Windows-1252" para que salga el símbolo del € en el XML
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt} indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(document);
			try {
				
				FileWriter fw = new FileWriter("src\\es\\florida\\seccion03\\zapateria_actualizado.xml");
				StreamResult result = new StreamResult(fw); //flujo de datos entra directamente al documento
				aTransformer.transform(source, result);
				System.out.println("\nLos datos se han guardado correctamente");
				fw.close();

			} catch (IOException | TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParserConfigurationException | TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
