package es.florida.seccion03;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio19 {

	public static void main(String[] args) {

		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\zapateria.xml"));

			Element raiz = document.getDocumentElement();
			NodeList nodelist = document.getElementsByTagName("zapato");

			int numeronodos = nodelist.getLength();
			System.out.println("El nodo principal \"" + raiz.getNodeName() + "\" contiene " + numeronodos
					+ " nodos u objetos.");

		} catch (SAXException | ParserConfigurationException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
