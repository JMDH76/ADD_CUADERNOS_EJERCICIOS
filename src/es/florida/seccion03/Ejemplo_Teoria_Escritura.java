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

import org.w3c.dom.*;



public class Ejemplo_Teoria_Escritura {
	
	public static class ListaCanciones{
		
		private ArrayList<Cancion> lista = new ArrayList<Cancion>(); //Objeto lista para acumular las canciones
		
		public ListaCanciones() {}   //Constructor vacio

		public void anyadirCancion(Cancion can) { 	//añade cancion a la lista
			lista.add(can);
		}
		
		public ArrayList<Cancion> getListaCanciones(){	//presenta la lista
			return lista;
		}
	}
	
	
	
	public static class Cancion {
		
		private String id, titulo, artista, anyo, formato;
		
		public Cancion (String id, String titulo, String artista, String anyo, String formato) {
			this.id = id;
			this.titulo = titulo;
			this.artista = artista;
			this.anyo = anyo;
			this.formato = formato;
		}
		
		String getId () {
			return id;
		}

		String getTitulo() {
			return titulo;
		}
		
		String getArtista() {
			return artista;
		}
		
		String getAnyo () {
			return anyo;
		}
		
		String getFormato() {
			return formato;
		}

	}
	
	public static void writeXmlFile(ListaCanciones lista) {
		
		try {
			
		DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuild = dFact.newDocumentBuilder();
		Document doc = dBuild.newDocument();
		
		Element raiz = doc.createElement("canciones");
		doc.appendChild(raiz);
		for (Cancion can : lista.getListaCanciones()) {
			
			Element cancion = doc.createElement("cancion");
			String id = String.valueOf(can.getId());
			cancion.setAttribute("id", id);
			raiz.appendChild(cancion); // creamos un hijo de raiz
			
			Element titulo = doc.createElement("titulo");	//Crea la etiqueta
			titulo.appendChild(doc.createTextNode(String.valueOf(can.getTitulo()))); //Generamos el texto de la etiqueta
			cancion.appendChild(titulo); //creamos hijo de cancion
			
			Element artista = doc.createElement("artista");
			artista.appendChild(doc.createTextNode(String.valueOf(can.getArtista())));
			cancion.appendChild(artista);
			
			Element anyo = doc.createElement("anyo");
			anyo.appendChild(doc.createTextNode(String.valueOf(can.getAnyo())));
			cancion.appendChild(anyo);
			
			Element formato = doc.createElement("formato");
			formato.appendChild(doc.createTextNode(String.valueOf(can.getFormato())));
			cancion.appendChild(formato);
		}
		
		//Guardar documento en disco
		//Crear serializador
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer = tranFactory.newTransformer();
		
		//Dar formato al documento (tabulaciones, sangrias,...):
		aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); //Codificacion de XML
		aTransformer.setOutputProperty("{http://xml.apache.org/xslt} indent-amount" , "4");	//indentacion del fichero
		aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		DOMSource source = new DOMSource(doc);
		
		//definir nombre del fichero y guardar:
		
		try {
		FileWriter fw = new FileWriter("src\\es\\florida\\seccion03\\Canciones_copia.xml");
		StreamResult result = new StreamResult(fw);
		aTransformer.transform(source, result); //metodo que realiza propiamente la escritura en diaco
		fw.close();
		
		} catch (IOException | TransformerException e) {
			e.printStackTrace();
		}

		} catch (ParserConfigurationException | TransformerConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {

		ListaCanciones lista = new ListaCanciones();
		Cancion can;
		int idUltimo = 0;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\Canciones.xml"));

			Element raiz = document.getDocumentElement();
			System.out.println("Contenido XML de " + raiz.getNodeName());
			NodeList nodeList = document.getElementsByTagName("cancion");
			
			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);
				System.out.println("\n");
				Element eElement = (Element) node;
				String id = eElement.getAttribute("id");
				System.out.println("ID cancion: " + id);
				String titulo = eElement.getElementsByTagName("titulo").item(0).getTextContent();
				System.out.println("Titulo: " + titulo);
				String artista = eElement.getElementsByTagName("artista").item(0).getTextContent();
				System.out.println("Artista: " + artista);
				String anyo = eElement.getElementsByTagName("anyo").item(0).getTextContent();
				System.out.println("Año: " + anyo);
				String formato = eElement.getElementsByTagName("formato").item(0).getTextContent();
				System.out.println("Formato: " + formato);
				can = new Cancion(id, titulo, artista, anyo, formato); // Mientras leemos vamos pasando a una lista lo objetos cancion
				lista.anyadirCancion(can);
				idUltimo = Integer.parseInt(id); // para poder añadir después más canciones a la lista y continuar desde la última
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nCreada lista de canciones.\n");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //equivale a Scanner
		System.out.println ("¿Anyadir nueva cancion? (s/n)");
		
		try {
			String respuesta = br.readLine();
			while (respuesta.equals("s")) {
				System.out.print("Titulo: ");	String titulo = br.readLine();
				System.out.print("Artista: "); String artista = br.readLine();
				System.out.print("Año: "); String anyo = br.readLine();
				System.out.print("Formato: "); String formato = br.readLine();
				idUltimo++;	//no pedimos el id porque es autoincrementado para añadir por el final
				can = new Cancion(Integer.toString(idUltimo), titulo, artista, anyo, formato); //creamos el objeto cancio
				lista.anyadirCancion(can); //añadimos a la lista
				System.out.println("\nDesea añadir una nueva canción? (s/n)");
				respuesta = br.readLine(); 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeXmlFile(lista); //añadir datos al xml
	}
}
