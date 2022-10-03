package acd.tema1.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EjerciciosXml {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		EjerciciosXml ejerciciosXml = new EjerciciosXml();
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		Document doc = docBuilder.newDocument();
		
		Element tagLibreria = doc.createElement("libreria");
		doc.appendChild(tagLibreria);

		Element tagNombre = doc.createElement("nombre");
		tagLibreria.appendChild(tagNombre);
		tagNombre.setTextContent("Librería Pepe");
		
		Element tagDireccion = doc.createElement("dirección");
		tagLibreria.appendChild(tagDireccion);
		tagDireccion.setTextContent("C/ Amiel 12");
		
		Element tagLibros = doc.createElement("libros");
		tagLibreria.appendChild(tagLibros);
		
		Element tagLibro = doc.createElement("libro");
		tagLibros.appendChild(tagLibro);
		tagLibro.setAttribute("isbn", "1234567890");
		
		Element tagTitulo = doc.createElement("titulo"); 
		tagLibro.appendChild(tagTitulo);
		tagTitulo.setTextContent("Don Quijote de la Mancha");
		
		Element tagAutor = doc.createElement("autor");
		tagLibro.appendChild(tagAutor);
		tagAutor.setTextContent("Miguel De Cervantes");
		
		Element tagLibro2 = doc.createElement("libro");
		tagLibros.appendChild(tagLibro2);
		tagLibro2.setAttribute("isbn", "2345678901");
		
		Element tagTitulo2  =doc.createElement("titulo");
		tagLibro2.appendChild(tagTitulo2);
		tagTitulo2.setTextContent("Lazarillo de Tormes");
		
		Element tagAutor2 = doc.createElement("autor");
		tagLibro2.appendChild(tagAutor2);
		tagAutor2.setTextContent("Anónimo");
		
		Element tagLibro3 = doc.createElement("libro");
		tagLibros.appendChild(tagLibro3);
		tagLibro3.setAttribute("isbn", "45678910123");
		
		Element tagTitulo3  =doc.createElement("titulo");
		tagLibro3.appendChild(tagTitulo3);
		tagTitulo3.setTextContent("La vida es un sueño");
		
		Element tagAutor3 = doc.createElement("autor");
		tagLibro3.appendChild(tagAutor3);
		tagAutor3.setTextContent("Pedro Calderón de la Barca");
		
		Element tagLibro4 = doc.createElement("libro");
		tagLibros.appendChild(tagLibro4);
		tagLibro4.setAttribute("isbn", "8901234567");
		
		Element tagTitulo4  =doc.createElement("titulo");
		tagLibro4.appendChild(tagTitulo4);
		tagTitulo4.setTextContent("100 años de soledad");
		
		Element tagAutor4 = doc.createElement("autor");
		tagLibro4.appendChild(tagAutor4);
		tagAutor4.setTextContent("Gabriel García Márquez");
		
		ejerciciosXml.crearXml(doc, System.out);
		//mostrar xml por consola
		try (FileOutputStream output = new FileOutputStream("libreria.xml")) {
			ejerciciosXml.crearXml(doc, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que escribe el xml creado en Java
	 * @param doc
	 * @param output
	 * @throws TransformerException
	 */
	public void crearXml(Document doc, OutputStream output) throws TransformerException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(output);

		transformer.transform(source, result);

	}
}
